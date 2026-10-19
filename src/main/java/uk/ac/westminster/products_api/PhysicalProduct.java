// A PhysicalProduct IS-A Product because it requires all the attributes and methods of the product class

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {}

    public PhysicalProduct(long id, String name, Double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
