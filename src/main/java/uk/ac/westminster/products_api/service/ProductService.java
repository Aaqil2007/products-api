package uk.ac.westminster.products_api.service;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.controller.ProductController;
import uk.ac.westminster.products_api.model.DigitalProduct;
import uk.ac.westminster.products_api.model.PhysicalProduct;
import uk.ac.westminster.products_api.model.Product;
import uk.ac.westminster.products_api.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo=repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return repo.findById(id);
    }

    public void deleteProduct(Long id) {
        repo.delete(id);
    }

    public List<Product> findByName(String name) {
        return repo.findByName(name);
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product product : repo.findAll()) {
            summaries.add(product.getSummary());
        }
        return summaries;
    }
}
