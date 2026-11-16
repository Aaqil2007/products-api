package uk.ac.westminster.products_api.repository;

import org.springframework.stereotype.Repository;
import uk.ac.westminster.products_api.model.DigitalProduct;
import uk.ac.westminster.products_api.model.PhysicalProduct;
import uk.ac.westminster.products_api.model.Product;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private long nextId= 1L;

    public InMemoryProductRepository() {
        save(new DigitalProduct(nextId++, "Clean Code (E-book)", 29.99, "/downloads/clean-code.pdf", 4.2));
        save(new PhysicalProduct(nextId++,  "27-inch Monitor", 249.99, 5.4, "61cm x 41cm x 18cm"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Product> findByName(String name) {
        return store.values().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
