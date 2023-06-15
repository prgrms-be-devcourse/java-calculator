package com.wonu606.calculator.model;

import java.util.Objects;

public class CalculationResult {

    private final String expression;
    private final double result;

    public CalculationResult(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculationResult that = (CalculationResult) o;
        return Double.compare(that.getResult(), getResult()) == 0 && Objects.equals(
                getExpression(), that.getExpression());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExpression(), getResult());
    }
}
