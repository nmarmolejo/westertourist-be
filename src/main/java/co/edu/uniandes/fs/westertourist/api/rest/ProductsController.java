package co.edu.uniandes.fs.westertourist.api.rest;

import co.edu.uniandes.fs.westertourist.domain.Product;
import co.edu.uniandes.fs.westertourist.services.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private static final Logger LOGGER = LogManager.getLogger(ProductsController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Product>> getProducts() {
        LOGGER.info("Processing get products request");
        List<Product> products = productService.getProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        LOGGER.info("Processing get product request with id " + id);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        Product product = productService.getProduct(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        LOGGER.info("Processing add product request");
        LOGGER.debug("Product entity: " + product.toString());

        String errorMessage = validateForInsert(product);
        if (errorMessage != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Product addedProduct = productService.addProduct(product);

        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = {"application/json"})
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        LOGGER.info("Processing update product request");
        LOGGER.debug("Product entity: " + product.toString());
        String errorMessage = validateForUpdate(product);
        if (errorMessage != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        Product updateProduct = productService.addProduct(product);

        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        LOGGER.info("Processing delete product request with id " + id);

        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        boolean result = productService.deleteProduct(id);

        if (!result) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete product with id " + id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String validateForInsert(Product product) {
        return null;
    }

    private String validateForUpdate(Product product) {
        return null;
    }

}
