package uk.ac.westminster.products_api.model;

import java.util.List;

public class BundleProduct extends Product{
    private List<Product> products;
    private double noOfItems;

    public BundleProduct() {}

    public BundleProduct(Long id, String name, double price, List<Product> products) {
        super(id, name, price);
        this.products = products;
    }

    public List<Product> getListOFProducts() {
        return products;
    }

    @Override
    public String getSummary() {
        return "Bundle: " + getName() + " | No. of items: " + products.size();
    }
}
