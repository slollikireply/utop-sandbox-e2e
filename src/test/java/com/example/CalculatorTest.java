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
        assertEquals(5, calc.abs(-5)); // Added to test negative input
        assertEquals(0, calc.abs(0));  // Added to test zero input
    }

    @Test
    void isEvenTrueForTwo() {
        assertTrue(calc.isEven(2));
        assertTrue(calc.isEven(0)); // Added to test zero, an even number
        assertTrue(calc.isEven(4)); // Added to test another even number
        assertFalse(calc.isEven(1)); // Added to test an odd number
        assertFalse(calc.isEven(3)); // Added to test another odd number
    }
}
