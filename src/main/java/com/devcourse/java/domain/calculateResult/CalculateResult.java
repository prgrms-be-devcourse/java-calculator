package com.devcourse.java.domain.calculateResult;

public class CalculateResult {
    private static final String EQUAL = " = ";
    private final String expression;
    private final Number result;

    public CalculateResult(String expression, Number result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + EQUAL + result;
    }
}
