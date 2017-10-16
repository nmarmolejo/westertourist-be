package co.edu.uniandes.fs.westertourist.repository;

import co.edu.uniandes.fs.westertourist.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findByCategoryId(Integer categoryId);
}
