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
    void appliesDiscountCalculatesCorrectly() {
        assertEquals(90.0, calculator.applyDiscount(100.0, 10.0));
    }

    @Test
    void appliesDiscountWithZeroPercent() {
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0));
    }

    @Test
    void appliesDiscountWithFullPercent() {
        assertEquals(0.0, calculator.applyDiscount(100.0, 100.0));
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
    void rejectsDiscountGreaterThanHundredPercent() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.applyDiscount(100.0, 105.0));
    }

    @Test
    void appliesDiscountWithNegativePrice() {
        assertEquals(-90.0, calculator.applyDiscount(-100.0, 10.0));
    }

    @Test
    void appliesDiscountWithSmallPrice() {
        assertEquals(0.0, calculator.applyDiscount(0.01, 100.0));
    }

    @Test
    void appliesDiscountWithLargePrice() {
        assertEquals(900000000.0, calculator.applyDiscount(1000000000.0, 10.0));
    }

    @Test
    void appliesDiscountWithFiftyPercent() {
        assertEquals(50.0, calculator.applyDiscount(100.0, 50.0));
    }

    @Test
    void appliesDiscountWithFractionalPercent() {
        assertEquals(66.67, calculator.applyDiscount(100.0, 33.33), 0.01);
    }
}