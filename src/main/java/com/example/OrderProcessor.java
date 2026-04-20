package com.example;

public class OrderProcessor {

    private final PriceCalculator pricing;
    private final UserValidator users;

    public OrderProcessor(PriceCalculator pricing, UserValidator users) {
        this.pricing = pricing;
        this.users = users;
    }

    public double quote(String username, int customerAge, double basePrice) {
        if (!users.isValidUsername(username)) {
            throw new IllegalArgumentException("invalid username");
        }
        if (!users.isValidAge(customerAge)) {
            throw new IllegalArgumentException("invalid age");
        }
        double discount = customerAge >= 65 ? 15.0 : 0.0;
        return pricing.computeTotal(basePrice, discount, 22.0);
    }
}
