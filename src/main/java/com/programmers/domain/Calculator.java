package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final ExpressionValidator validator;
    private final PostfixConverter postfixConverter;

    public Calculator() {
        validator = new ExpressionValidator();
        postfixConverter = new PostfixConverter();
    }

    public int calculateInfixExpression(List<String> expression) {
        validator.validate(expression);

        List<String> postfixExpression = postfixConverter.convert(expression);

        return calculatePostfixExpression(postfixExpression);
    }

    public int calculatePostfixExpression(List<String> expression) {
        Stack<Integer> numbers = new Stack<>();
        for (String expr : expression) {
            if (Arithmetic.isNumber(expr)) {
                numbers.push(Integer.parseInt(expr));
            } else {
                int result = binaryOperation(numbers.pop(), numbers.pop(), Operator.getValue(expr));
                numbers.push(result);
            }
        }

        return numbers.pop();
    }

    private int binaryOperation(int a, int b, Operator operator) {
        return switch (operator) {
            case PLUS -> b + a;
            case MINUS -> b - a;
            case MULTIPLY -> b * a;
            case DIVIDE -> b / a;
        };
    }
}
