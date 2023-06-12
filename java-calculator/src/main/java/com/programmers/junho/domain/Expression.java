package com.programmers.junho.domain;

import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.junho.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.junho.domain.ArithmeticOperators.isNotOperator;
import static com.programmers.junho.domain.constant.CalculatorConstant.*;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        validateExpression(expression);
        this.expression = expression;
    }

    private void validateExpression(String expression) {
        if (!Pattern.matches(REGEX.getValue(), appendBlankForRegex(expression))) {
            throw new IllegalArgumentException("잘못된 형식의 식을 입력하셨습니다.");
        }
    }

    private String appendBlankForRegex(String expression) {
        return expression + BLANK.getValue();
    }

    public String getPostfixExpression() {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<ArithmeticOperators> stack = new Stack<>();

        String[] tokens = this.expression.split(DELIMITER.getValue());
        for (String token : tokens) {
            convertToPostfix(postfixExpression, stack, token);
        }
        appendAllExistingElement(postfixExpression, stack);
        return postfixExpression.toString().trim();
    }

    private void convertToPostfix(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack, String token) {
        if (isNotOperator(token)) {
            postfixExpression.append(token).append(BLANK.getValue());
            return;
        }
        var operator = convertTokenToOperator(token);
        while (isStackNotEmptyAndOperatorPriorityLower(stack, operator)) {
            postfixExpression.append(stack.pop().getOperator()).append(BLANK.getValue());
        }
        stack.push(operator);
    }

    private void appendAllExistingElement(StringBuilder postfixExpression, Stack<ArithmeticOperators> stack) {
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop().getOperator()).append(BLANK.getValue());
        }
    }
    private boolean isStackNotEmptyAndOperatorPriorityLower(Stack<ArithmeticOperators> stack, ArithmeticOperators operator) {
        return !stack.isEmpty() && stack.peek().getPriority() >= operator.getPriority();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}