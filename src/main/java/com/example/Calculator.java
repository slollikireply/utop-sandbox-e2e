package com.example;

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
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        return a % b;
    }

    public int abs(int a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public boolean isEven(int a) {
        return a % 2 == 0;
    }

    public boolean isPositive(int a) {
        return a > 0;
    }
}
