// A PhysicalProduct IS-A Product because it requires all the attributes and methods of the product class

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(long id, String name, Double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;

    }

    @Override
    public String getSummary() {
        return "Physcal: " + getName() + " | Weight: " + weightKg + " | Dimensions: " + dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1-capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
