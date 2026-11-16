package uk.ac.westminster.products_api.model;

public interface Discountable {
    void applyDiscount(double rate);
    double getDiscountedPrice();
}
