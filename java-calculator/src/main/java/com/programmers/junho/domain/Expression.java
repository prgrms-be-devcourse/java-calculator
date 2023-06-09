package com.programmers.junho.domain;

import java.util.Stack;
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

    public String getPostfixExpression() {
        String expression = removeSpace();

        StringBuilder postfixExpression = new StringBuilder();

        Stack<ArithmeticOperators> stack = new Stack<>();

        String[] tokens = expression.split("");
        for (String token : tokens) {
            // 펴연산자 바로 출력
            if (!ArithmeticOperators.isOperator(token)) {
                postfixExpression.append(token);
                continue;
            }
            // 연산자면
            ArithmeticOperators operator = ArithmeticOperators.convertTokenToOperator(token);
            while (!stack.isEmpty() && stack.peek().getPriority() >= operator.getPriority()) {
                postfixExpression.append(stack.pop().getOperator());
            }
            if (stack.isEmpty() || stack.peek().getPriority() < operator.getPriority()) {
                stack.push(operator);
            }
        }
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop().getOperator());
        }
        return postfixExpression.toString();
    }

    private String removeSpace() {
        return this.expression.replace(" ", "");
    }
}

