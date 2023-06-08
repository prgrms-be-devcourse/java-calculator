package com.devcourse.java.domain.storage;

public class CalculateResult {
    private static final String EQUAL = " = ";
    private final String expression;
    private final Double result;

    public CalculateResult(String expression, Double result) {
        this.expression = expression;
        this.result = result;
    }

    public double getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return expression + EQUAL + result;
    }
}
