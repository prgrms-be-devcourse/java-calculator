package com.programmers.junho.domain;

import java.util.Stack;

import static com.programmers.junho.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.junho.domain.ArithmeticOperators.isNotOperator;
import static com.programmers.junho.domain.constant.CalculatorConstant.DELIMITER;
import static com.programmers.junho.domain.utils.StringUtil.convertStringToInt;

public class Calculator {

    public int calculate(String value) {
        Expression expression = new Expression(value);
        String postfixExpression = expression.getPostfixExpression();
        return calculateWithPostfixExpression(postfixExpression);
    }

    private Integer calculateWithPostfixExpression(String postfixExpression) {
        String[] tokens = postfixExpression.split(DELIMITER.getValue());
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
}
