package com.programmers.java.util;

public class OperandChecker {
    private OperandChecker() {
        throw new AssertionError();
    }

    public static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
