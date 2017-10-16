package co.edu.uniandes.fs.westertourist.services;

import co.edu.uniandes.fs.westertourist.domain.Product;
import co.edu.uniandes.fs.westertourist.domain.Rol;
import co.edu.uniandes.fs.westertourist.repository.ProductRepository;
import co.edu.uniandes.fs.westertourist.repository.RolRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(ProductService.class);
	
    public List<Product> getProducts() {
		LOGGER.info("Processing get products request");
		
		List<Product> result = productRepository.findAll();
		
		LOGGER.info(result.size() + " records fetched");
		
		return result;
	}
	
    public Product getProduct(Integer id) {
		LOGGER.info("Processing get Product request with id " + id);
		
		Product result = productRepository.findById(id);
		if (result == null) 
			LOGGER.info("No records founds for id " + id);
		
		return result;
	}
	
    public Product addProduct(Product product)  {
		LOGGER.info("Processing add Product request");
		LOGGER.debug("Product entity: " + product.toString());
		
		try {
			Product savedProduct = productRepository.save(product);
			if (savedProduct == null) 
				LOGGER.error("Unable to insert or update record");
			
			return savedProduct;
		} catch (Exception e) {
			LOGGER.error("Cannot insert product", e);
			return null;
		}
		
	}
	
    public Product updateProduct(Product product)  {
		LOGGER.info("Processing update Product request");
		LOGGER.debug("Product entity: " + product.toString());
		
		return addProduct(product);
	}
	
    public boolean deleteProduct(Integer id) {
		LOGGER.info("Processing delete Product request with id " + id);
		
		try {
			productRepository.delete(id);
		} catch (Exception e) {
			LOGGER.error("Cannot delete Product record for id " + id);
		}
		
		return true;
	}
	
}
