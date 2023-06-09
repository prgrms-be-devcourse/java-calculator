package com.programmers.junho.domain;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.junho.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.junho.domain.ArithmeticOperators.isNumber;

public class Expression {
    public static final String REGEX = "^\\d+\\s([-+*/]\\s\\d+\\s)+$";
    public static final String DELIMITER = " ";
    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (!Pattern.matches(REGEX, appendBlankForRegex(expression))) {
            throw new IllegalArgumentException("잘못된 형식의 식을 입력하셨습니다.");
        }
    }

    private String appendBlankForRegex(String expression) {
        return expression + " ";
    }

    public String getPostfixExpression() {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<ArithmeticOperators> stack = new Stack<>();

        String[] tokens = this.expression.split(DELIMITER);
        System.out.println(Arrays.toString(tokens));
        for (String token : tokens) {
            converseToPostfix(postfixExpression, stack, token);
        }
        appendAllExistingElement(postfixExpression, stack);
        return postfixExpression.toString().trim();
    }

    private void converseToPostfix(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack, String token) {
        if (isNumber(token)) {
            postfixExpression.append(token).append(" ");
            return;
        }
        var operator = convertTokenToOperator(token);
        while (isStackNotEmptyAndOperatorPriorityLower(stack, operator)) {
            postfixExpression.append(stack.pop().getOperator()).append(" ");
        }
        stack.push(operator);
    }

    private void appendAllExistingElement(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack) {
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop().getOperator()).append(" ");
        }
    }
    private boolean isStackNotEmptyAndOperatorPriorityLower(Stack<ArithmeticOperators> stack, ArithmeticOperators operator) {
        return !stack.isEmpty() && stack.peek().getPriority() >= operator.getPriority();
    }
}

