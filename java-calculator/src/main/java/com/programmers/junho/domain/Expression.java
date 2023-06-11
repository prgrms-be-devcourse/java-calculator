package com.programmers.junho.domain;

import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.junho.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.junho.domain.ArithmeticOperators.isNotOperator;

public class Expression {
    private static final String REGEX = "^\\d+\\s([-+*/]\\s\\d+\\s)+$";
    private static final String DELIMITER = " ";
    public static final String BLANK = " ";
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
        for (String token : tokens) {
            convertToPostfix(postfixExpression, stack, token);
        }
        appendAllExistingElement(postfixExpression, stack);
        return postfixExpression.toString().trim();
    }

    private void convertToPostfix(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack, String token) {
        if (isNotOperator(token)) {
            postfixExpression.append(token).append(BLANK);
            return;
        }
        var operator = convertTokenToOperator(token);
        while (isStackNotEmptyAndOperatorPriorityLower(stack, operator)) {
            postfixExpression.append(stack.pop().getOperator()).append(BLANK);
        }
        stack.push(operator);
    }

    private void appendAllExistingElement(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack) {
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop().getOperator()).append(BLANK);
        }
    }
    private boolean isStackNotEmptyAndOperatorPriorityLower(Stack<ArithmeticOperators> stack, ArithmeticOperators operator) {
        return !stack.isEmpty() && stack.peek().getPriority() >= operator.getPriority();
    }
}

