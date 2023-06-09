package com.programmers.junho.domain;

import java.util.Stack;

public class Calculator {

    private final Expression expression;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
    }

    public int calculate() {
        String postfixExpression = expression.getPostfixExpression();
        String[] tokens = postfixExpression.split("");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            extracted(stack, token);
        }
        // 스택 결과값
        return stack.pop();
    }

    private void extracted(Stack<Integer> stack, String token) {
        if (ArithmeticOperators.isNumber(token)) {
            stack.push(Integer.parseInt(token));
            return;
        }
        ArithmeticOperators operator = ArithmeticOperators.convertTokenToOperator(token);
        Integer second = stack.pop();
        Integer first = stack.pop();
        stack.push(operator.apply(first, second));
    }
}
