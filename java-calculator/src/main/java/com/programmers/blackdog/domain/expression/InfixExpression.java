package com.programmers.blackdog.domain.expression;

import com.programmers.blackdog.domain.ArithmeticOperators;

import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

import static com.programmers.blackdog.domain.ArithmeticOperators.convertTokenToOperator;
import static com.programmers.blackdog.domain.ArithmeticOperators.isNotOperator;
import static com.programmers.blackdog.domain.constant.Regex.*;

public class InfixExpression implements Expression {
    private final String expression;

    public InfixExpression(String expression) {
        validateInfixExpression(expression);
        this.expression = expression;
    }

    private void validateInfixExpression(String expression) {
        if (!Pattern.matches(REGEX, appendBlankForRegex(expression))) {
            throw new IllegalArgumentException("잘못된 형식의 식을 입력하셨습니다.");
        }
    }

    private String appendBlankForRegex(String expression) {
        return expression + BLANK;
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
        ArithmeticOperators operator = convertTokenToOperator(token);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfixExpression that = (InfixExpression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}