package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

    private final PriceCalculator calculator = new PriceCalculator();

    @Test
    void appliesDiscountReturnsNonZero() {
        assertNotEquals(0.0, calculator.applyDiscount(100.0, 10.0));
    }

    @Test
    void appliesTaxRunsWithoutError() {
        calculator.applyTax(100.0, 22.0);
    }

    @Test
    void computesTotalProducesFiniteNumber() {
        double result = calculator.computeTotal(100.0, 10.0, 22.0);
        assertTrue(Double.isFinite(result));
    }

    @Test
    void affordableWhenPriceBelowBudget() {
        assertTrue(calculator.isAffordable(50.0, 100.0));
    }

    @Test
    void rejectsNegativeDiscount() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.applyDiscount(100.0, -5.0));
    }

    @Test
    void appliesDiscountCorrectly() {
        assertEquals(90.0, calculator.applyDiscount(100.0, 10.0));
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0));
        assertEquals(0.0, calculator.applyDiscount(100.0, 100.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.applyDiscount(100.0, 110.0));
        assertEquals(99.99, calculator.applyDiscount(100.0, 0.01), 0.001);
        // Added assertions to cover edge cases
        assertEquals(0.0, calculator.applyDiscount(0.0, 50.0)); // Zero price
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0)); // Zero discount
        // Additional assertions to kill mutations
        assertThrows(IllegalArgumentException.class, () -> calculator.applyDiscount(100.0, 101.0)); // Discount > 100%
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0)); // Discount of 0%
    }
}
