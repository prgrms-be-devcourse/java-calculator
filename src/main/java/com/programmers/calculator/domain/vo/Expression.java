package com.programmers.calculator.domain.vo;

public class Expression implements CharSequence {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public int length() {
        return expression.length();
    }

    @Override
    public char charAt(int index) {
        return expression.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return expression.subSequence(start, end);
    }

    @Override
    public String toString() {
        return expression;
    }
}
