package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addReturnsSumForIdenticalOperands() {
        assertEquals(4, calc.add(2, 2));
    }

    @Test
    void subtractReturnsZeroForEqualOperands() {
        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    void multiplyReturnsZeroWhenOneOperandIsZero() {
        assertEquals(0, calc.multiply(3, 0));
    }

    @Test
    void multiplyHandlesPositiveAndNegativeOperands() {
        assertEquals(6, calc.multiply(2, 3)); // Added test for both operands positive
        assertEquals(-6, calc.multiply(-2, 3)); // Added test for one operand negative
        assertEquals(6, calc.multiply(-2, -3)); // Added test for both operands negative
    }

    @Test
    void divideReturnsOneForEqualOperands() {
        assertEquals(1, calc.divide(4, 4));
    }

    @Test
    void absReturnsInputForPositive() {
        assertEquals(5, calc.abs(5));
        assertEquals(0, calc.abs(0)); // Added test for zero input
        assertEquals(5, calc.abs(-5)); // Added test for negative input
    }

    @Test
    void isEvenTrueForTwo() {
        assertTrue(calc.isEven(2));
        assertTrue(calc.isEven(4)); // Added test for another even number
        assertTrue(calc.isEven(0)); // Added test for zero, which is even
        assertFalse(calc.isEven(1)); // Added test for an odd number
        assertFalse(calc.isEven(3)); // Added test for another odd number
    }
}
