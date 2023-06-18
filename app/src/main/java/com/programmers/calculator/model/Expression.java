package com.programmers.calculator.model;

import com.programmers.calculator.util.Converter;
import com.programmers.calculator.util.PostFixManager;

public class Expression {
    private final String expression;

    public Expression(String expression) {
//        if (!validateExpression()) {
//            throw new IllegalArgumentException("잘못된 입력입니다.");
//        }
        this.expression = expression;
    }

    private boolean validateExpression() {
        return Converter.isValid(expression);
    }

    public int getResult() {
        String postFixString = Converter.getPostFixString(expression);
        return PostFixManager.calculate(postFixString);
    }

    @Override
    public String toString() {
        return expression;
    }
}
