package uk.ac.westminster.products_api.repository;

import uk.ac.westminster.products_api.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
    List<Product> findByName(String name);
}
