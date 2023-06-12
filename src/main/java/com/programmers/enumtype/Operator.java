package com.programmers.enumtype;

import com.programmers.util.Arithmetic;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator getValue(String operator) {
        return switch (operator) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            default -> throw new UnsupportedOperationException(Arithmetic.WRONG_OPERATOR);
        };
    }

    @Override
    public String toString() {
        return operator;
    }
}
