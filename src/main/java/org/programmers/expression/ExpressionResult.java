package org.programmers.expression;

import org.programmers.constant.ExpressionSymbol;

public class ExpressionResult {

    private final String expression;

    private final double answer;

    public ExpressionResult(String expression, double answer) {
        this.expression = expression;
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
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
                + answer;
    }
}
