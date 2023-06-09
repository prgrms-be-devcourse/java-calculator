package com.programmers.junho.domain;

import java.util.regex.Pattern;

public class Expression {
    public static final String REGEX = "^\\d+\\s?([-+*/]\\s?\\d+\\s?)+$";
    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (!Pattern.matches(REGEX, expression)) {
            throw new IllegalArgumentException("잘못된 형식의 식을 입력하셨습니다.");
        }
    }
}
