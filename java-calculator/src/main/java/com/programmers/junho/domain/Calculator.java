package com.programmers.junho.domain;

import java.util.Stack;

import static com.programmers.junho.domain.ArithmeticOperators.*;

public class Calculator {

    private static final String DELIMITER = " ";
    private final Expression expression;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
    }

    public int calculate() {
        String postfixExpression = expression.getPostfixExpression();
        String[] tokens = postfixExpression.split(DELIMITER);
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            postfixEvaluate(stack, token);
        }
        return stack.pop();
    }

    private void postfixEvaluate(Stack<Integer> stack, String token) {
        if (isNumber(token)) {
            stack.push(Integer.parseInt(token));
            return;
        }
        Integer secondValue = stack.pop();
        Integer firstValue = stack.pop();
        stack.push(convertTokenToOperator(token).apply(firstValue, secondValue));
    }
}
