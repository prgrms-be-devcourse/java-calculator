package org.programmers.expression;

import org.programmers.constant.ExpressionSymbol;

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

    @Override
    public String toString() {
        return makeExpression();
    }

    private String makeExpression() {
        return expression
                + ExpressionSymbol.BLANK_SYMBOL.getSymbol()
                + ExpressionSymbol.EQUAL_SYMBOL.getSymbol()
                + ExpressionSymbol.BLANK_SYMBOL.getSymbol()
                + result;
    }
}
