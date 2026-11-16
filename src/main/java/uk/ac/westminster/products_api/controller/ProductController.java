package uk.ac.westminster.products_api.controller;

import org.springframework.web.bind.annotation.*;
import uk.ac.westminster.products_api.model.DigitalProduct;
import uk.ac.westminster.products_api.model.Product;
import uk.ac.westminster.products_api.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

    @PostMapping()
    public Product addProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }
    // RequestBody changed from Product to DigitalProduct, done as a temporary fix for making the Product class abstract

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/summaries")
    public List<String> getSummaries() {return productService.getAllSummaries();}

}
