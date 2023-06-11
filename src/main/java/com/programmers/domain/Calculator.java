package com.programmers.domain;

import com.programmers.util.Arithmetic;

import java.util.Stack;

public class Calculator {

    private final ExpressionValidator validator;
    private final PostfixConverter postfixConverter;

    public Calculator() {
        validator = new ExpressionValidator();
        postfixConverter = new PostfixConverter();
    }

    public int calculateInfixExpression(String[] expression) {
        validator.validate(expression);

        String[] postfixExpression = postfixConverter.convert(expression);

        return calculatePostfixExpression(postfixExpression);
    }

    public int calculatePostfixExpression(String[] expression) {
        Stack<Integer> numbers = new Stack<>();
        for (String expr : expression) {
            if (Arithmetic.isNumber(expr)) {
                numbers.push(Integer.parseInt(expr));
            } else {
                int result = binaryOperation(numbers.pop(), numbers.pop(), expr);
                numbers.push(result);
            }
        }

        return numbers.pop();
    }

    private int binaryOperation(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                throw new UnsupportedOperationException(Arithmetic.WRONG_EXPRESSION);
        }
    }
}
