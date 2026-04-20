package com.example;

public class PriceCalculator {

    public double applyDiscount(double price, double discountPercent) {
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("invalid discount");
        }
        return price - (price * discountPercent / 100.0);
    }

    public double applyTax(double price, double taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("negative tax rate");
        }
        return price + (price * taxRate / 100.0);
    }

    public double computeTotal(double basePrice, double discountPercent, double taxRate) {
        double afterDiscount = applyDiscount(basePrice, discountPercent);
        return applyTax(afterDiscount, taxRate);
    }

    public boolean isAffordable(double price, double budget) {
        return price <= budget;
    }
}
