package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Intentionally incomplete tests: only `add` and `multiply` are covered so
 * PITest leaves surviving mutants on `subtract` and `divide`. The UTOP agent
 * is expected to close that gap by generating additional tests.
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
}
