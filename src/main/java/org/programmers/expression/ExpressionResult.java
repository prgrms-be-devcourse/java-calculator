package org.programmers.expression;

public class ExpressionResult {

    private final String expression;

    private final double result;

    public ExpressionResult(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public double getResult() {
        return result;
    }

}
