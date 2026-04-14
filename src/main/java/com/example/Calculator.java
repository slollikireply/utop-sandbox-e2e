package com.example;

/**
 * Trivial arithmetic helper used as a PITest fixture. Branches in
 * {@link #divide(int, int)} and the identity handling in {@link #subtract(int, int)}
 * are deliberately simple so mutation operators can produce surviving mutants
 * when the accompanying test suite is incomplete.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("division by zero");
        }
        return a / b;
    }
}
