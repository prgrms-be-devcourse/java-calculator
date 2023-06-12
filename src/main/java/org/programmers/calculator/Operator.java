package org.programmers.calculator;

public class Operator {
    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }        return num1 / num2;
    }
}
