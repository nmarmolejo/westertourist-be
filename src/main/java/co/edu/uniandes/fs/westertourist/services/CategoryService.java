package co.edu.uniandes.fs.westertourist.services;

import co.edu.uniandes.fs.westertourist.domain.Category;
import co.edu.uniandes.fs.westertourist.domain.Product;
import co.edu.uniandes.fs.westertourist.repository.CategoryRepository;
import co.edu.uniandes.fs.westertourist.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Category> getCategories() {
        LOGGER.info("Processing get categories request");

        List<Category> result = categoryRepository.findAll();

        LOGGER.info(result.size() + " records fetched");

        return result;
    }

    public Category getCategory(Integer id) {
        LOGGER.info("Processing get category request with id " + id);

        Category result = categoryRepository.findById(id);
        if (result == null)
            LOGGER.info("No records founds for id " + id);

        return result;
    }

    public List<Product> getCategoryProducts(Integer categoryId) {
        LOGGER.info("Processing get category products request for category id: " + categoryId);

        List<Product> products = productRepository.findByCategoryId(categoryId);

        return products;
    }

}
