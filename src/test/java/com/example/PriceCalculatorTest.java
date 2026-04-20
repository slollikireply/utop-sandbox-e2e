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
    }

    @Test
    void appliesZeroDiscountCorrectly() {
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0));
    }

    @Test
    void appliesMaximumDiscountCorrectly() {
        assertEquals(0.0, calculator.applyDiscount(100.0, 100.0));
    }

    @Test
    void rejectsDiscountGreaterThanHundred() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.applyDiscount(100.0, 105.0));
    }

    @Test
    void appliesSmallDiscountCorrectly() {
        assertEquals(99.9, calculator.applyDiscount(100.0, 0.1));
    }

    @Test
    void appliesMidRangeDiscountCorrectly() {
        assertEquals(50.0, calculator.applyDiscount(100.0, 50.0));
    }

    @Test
    void appliesVerySmallDiscountCorrectly() {
        assertEquals(99.999, calculator.applyDiscount(100.0, 0.001));
    }

    @Test
    void appliesDiscountToLargePriceCorrectly() {
        assertEquals(900000000.0, calculator.applyDiscount(1000000000.0, 10.0));
    }

    @Test
    void appliesDiscountToZeroPrice() {
        assertEquals(0.0, calculator.applyDiscount(0.0, 10.0));
    }

    @Test
    void appliesDiscountWithBoundaryValues() {
        assertEquals(0.0, calculator.applyDiscount(100.0, 100.0));
        assertEquals(100.0, calculator.applyDiscount(100.0, 0.0));
        assertEquals(99.999, calculator.applyDiscount(100.0, 0.001));
        assertEquals(0.0, calculator.applyDiscount(100.0, 100.0));
    }
}