package co.edu.uniandes.fs.westertourist.api.rest;

import co.edu.uniandes.fs.westertourist.domain.Category;
import co.edu.uniandes.fs.westertourist.domain.Product;
import co.edu.uniandes.fs.westertourist.services.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nmarmolejo on 16/10/17.
 */
@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    private static final Logger LOGGER = LogManager.getLogger(CategoriesController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Category>> getCategories() {
        LOGGER.info("Processing get categories request");
        List<Category> categories = categoryService.getCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<?> getCategory(@PathVariable Integer id) {
        LOGGER.info("Processing get category request with id " + id);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        Category category = categoryService.getCategory(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/products", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<?> getCategoryProducts(@PathVariable Integer id) {
        LOGGER.info("Processing get category request with id " + id);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{id} attribute is mandatory");
        }
        List<Product> products = categoryService.getCategoryProducts(id);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
