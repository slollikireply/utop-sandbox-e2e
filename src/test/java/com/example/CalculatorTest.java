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
    void divideReturnsOneForEqualOperands() {
        assertEquals(1, calc.divide(4, 4));
    }

    @Test
    void absReturnsInputForPositive() {
        assertEquals(5, calc.abs(5));
        assertEquals(5, calc.abs(-5)); // Added test for negative input
        assertEquals(0, calc.abs(0));  // Added test for zero input
    }

    @Test
    void isEvenTrueForTwo() {
        assertTrue(calc.isEven(2));
        assertTrue(calc.isEven(4)); // Additional test for even number
        assertTrue(calc.isEven(6)); // Additional test for even number
        assertFalse(calc.isEven(1)); // Test for odd number
        assertFalse(calc.isEven(3)); // Test for odd number
    }
}
