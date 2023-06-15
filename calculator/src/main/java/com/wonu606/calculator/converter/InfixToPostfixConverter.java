package com.wonu606.calculator.converter;

import com.wonu606.calculator.model.Operator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class InfixToPostfixConverter implements Converter<String, List<String>> {

    @Override
    public List<String> convert(String infixExpression) {
        Deque<String> operatorStack = new ArrayDeque<>();
        List<String> postfixExpression = new ArrayList<>();

        String[] tokens = infixExpression.split("\\s");

        for (String token : tokens) {
            processTokenIntoPostfix(operatorStack, postfixExpression, token);
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.add(operatorStack.pop());
        }
        return postfixExpression;
    }

    private void processTokenIntoPostfix(
            Deque<String> operatorStack, List<String> postfixExpression, String token) {
        if (isOperator(token)) {
            popWhileHigherPrecedence(operatorStack, postfixExpression, token);
            operatorStack.push(token);
            return;
        }
        postfixExpression.add(token);
    }

    private void popWhileHigherPrecedence(
            Deque<String> operatorStack, List<String> postfixExpression, String tokenOperator) {
        while (!operatorStack.isEmpty()
                && isHigherOrEqualPrecedence(operatorStack.peek(), tokenOperator)) {
            postfixExpression.add(operatorStack.pop());
        }
    }

    private boolean isHigherOrEqualPrecedence(String peekOperator, String tokenOperator) {
        int peekPrecedence = Objects.requireNonNull(Operator.get(peekOperator)).precedence;
        int tokenPrecedence = Objects.requireNonNull(Operator.get(tokenOperator)).precedence;
        return peekPrecedence <= tokenPrecedence;
    }

    private boolean isOperator(String token) {
        return Operator.get(token) != null;
    }
}
