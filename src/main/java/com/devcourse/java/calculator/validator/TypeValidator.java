package com.devcourse.java.calculator.validator;

public final class TypeValidator {

    private TypeValidator() {}

    public static boolean isInteger(String input) {
        return input.matches("^(0|[-]?[1-9]\\d*)$");
    }

    public static boolean isOperator(String token) {
        return token.matches("^[\\+\\-\\*\\/]$");
    }
}
