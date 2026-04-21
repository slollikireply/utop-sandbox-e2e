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
        assertEquals(3, calc.subtract(8, 5)); // Added to test subtraction with different positive operands
        assertEquals(-3, calc.subtract(5, 8)); // Added to test subtraction resulting in a negative number
        assertEquals(5, calc.subtract(5, 0)); // Added to test subtraction with zero
        assertEquals(-5, calc.subtract(0, 5)); // Added to test subtraction from zero
    }

    @Test
    void multiplyReturnsZeroWhenOneOperandIsZero() {
        assertEquals(0, calc.multiply(3, 0));
        assertEquals(6, calc.multiply(2, 3)); // Added to test multiplication of two positive numbers
        assertEquals(-6, calc.multiply(2, -3)); // Added to test multiplication of a positive and a negative number
        assertEquals(6, calc.multiply(-2, -3)); // Added to test multiplication of two negative numbers
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
