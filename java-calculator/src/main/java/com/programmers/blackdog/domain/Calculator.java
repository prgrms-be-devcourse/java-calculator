package com.programmers.junho.domain;

import com.programmers.blackdog.domain.calculator.AbstractCalculator;

import java.util.Stack;

import static com.programmers.blackdog.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.blackdog.domain.ArithmeticOperators.isNotOperator;
import static com.programmers.blackdog.domain.constant.Regex.DELIMITER;
import static com.programmers.blackdog.domain.utils.StringUtil.convertStringToInt;

public class Calculator implements AbstractCalculator {

    @Override
    public int calculate(Expression expression) {
        String postfixExpression = expression.getPostfixExpression();
        return calculateWithPostfixExpression(postfixExpression);
    }

    private Integer calculateWithPostfixExpression(String postfixExpression) {
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
}