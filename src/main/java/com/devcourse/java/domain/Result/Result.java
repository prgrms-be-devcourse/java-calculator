package com.devcourse.java.domain.Result;

public class Result {
    private static final String EQUAL = " = ";
    private final String expression;
    private final Double calculationValue;

    public Result(String expression, Double calculationValue) {
        this.expression = expression;
        this.calculationValue = calculationValue;
    }

    @Override
    public String toString() {
        return expression + EQUAL + calculationValue;
    }
}
