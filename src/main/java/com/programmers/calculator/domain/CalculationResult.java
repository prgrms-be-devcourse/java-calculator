package com.programmers.calculator.domain;

public class CalculationResult {
    private String expression;
    private double result;

    public CalculationResult(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }
}
