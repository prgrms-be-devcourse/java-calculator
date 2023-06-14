package com.programmers.dto;

public class ExpressionResult {
    private final String expression; //식
    private final int answer; //값

    public ExpressionResult(String expression, int answer) {
        this.expression = expression;
        this.answer = answer;
    }

    public String getExpression() {
        return this.expression;
    }

    public int getAnswer() {
        return this.answer;
    }
}
