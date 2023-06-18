package com.devcourse.java.domain.storage;

public class CalculateResult {
    private static final String EQUAL = " = ";
    private static final String NEW_LINE = "\n";
    private final String expression;
    private final Double result;

    public CalculateResult(String expression, Double result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public Double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return expression + EQUAL + result + NEW_LINE;
    }
}
