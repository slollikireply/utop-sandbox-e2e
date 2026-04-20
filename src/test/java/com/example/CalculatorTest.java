package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Feature branch: adds weak tests for subtract and divide. The UTOP agent
 * is expected to strengthen them so that PITest mutants on subtract/divide
 * are killed.
 */
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addsTwoPositiveIntegers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void addsNegativeIntegers() {
        assertEquals(-4, calculator.add(-1, -3));
    }

    @Test
    void multipliesTwoPositiveIntegers() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void subtractReturnsZeroForEqualOperands() {
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    void subtractHandlesDifferentOperands() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(-8, calculator.subtract(-5, 3));
    }

    @Test
    void divideReturnsOneForEqualOperands() {
        assertEquals(1, calculator.divide(7, 7));
    }
}
