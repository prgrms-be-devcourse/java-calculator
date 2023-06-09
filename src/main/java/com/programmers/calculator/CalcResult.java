package com.programmers.calculator;

public class CalcResult {

    private final String expression;
    private final String result;

    public CalcResult(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }
}
