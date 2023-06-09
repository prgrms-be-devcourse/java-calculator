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
            // 숫자면 일단 스택에 넣는다.
            if (!ArithmeticOperators.isOperator(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            // 문자면 두번 pop해서 연산해서 다시 스택에 넣는다
            ArithmeticOperators operator = ArithmeticOperators.convertTokenToOperator(token);
            Integer second = stack.pop();
            Integer first = stack.pop();
            stack.push(operator.apply(first, second));
        }
        // 스택 결과값
        return stack.pop();
    }
}
