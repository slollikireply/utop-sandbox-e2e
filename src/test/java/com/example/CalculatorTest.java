package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    }
}
