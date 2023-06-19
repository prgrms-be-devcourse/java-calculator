package com.programmers.java.calculator.dto;

public final class CalculationHistory {

    private final Long id;
    private final String expression;
    private final String result;

    private CalculationHistory(Long id, String expression, String result) {
        this.id = id;
        this.expression = expression;
        this.result = result;
    }

    public static CalculationHistory of(Long id, String expression, String result) {
        return new CalculationHistory(id, expression, result);
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getExpression() + " = " + getResult();
    }
}
