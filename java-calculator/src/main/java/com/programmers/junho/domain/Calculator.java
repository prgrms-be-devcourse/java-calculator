package com.programmers.junho.domain;

import java.util.Objects;
import java.util.Stack;

import static com.programmers.junho.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.junho.domain.ArithmeticOperators.isNotOperator;
import static com.programmers.junho.domain.utils.Util.convertStringToInt;

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
            evaluatePostfixNotation(stack, token);
        }
        return stack.pop();
    }

    private void evaluatePostfixNotation(Stack<Integer> stack, String token) {
        if (isNotOperator(token)) {
            stack.push(convertStringToInt(token));
            return;
        }
        Integer secondValue = stack.pop();
        Integer firstValue = stack.pop();
        stack.push(convertTokenToOperator(token).apply(firstValue, secondValue));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
