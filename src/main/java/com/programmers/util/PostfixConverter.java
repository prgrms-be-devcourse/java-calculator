package com.programmers.util;

import com.programmers.domain.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixConverter {
    public static String convert(String expression) {
        StringBuilder postfixExpression = new StringBuilder();
        Deque<Operator> operatorStack = new ArrayDeque<>();

        expression.chars()
                .mapToObj(token -> (char) token)
                .filter(token -> !Character.isWhitespace(token))
                .forEach(token -> {
                    if (Character.isDigit(token)) {
                        handleDigit(postfixExpression, token);
                    } else {
                        handleOperator(postfixExpression, operatorStack, token);
                    }
                });

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop().getSymbol());
        }
        return postfixExpression.toString();
    }

    private static void handleDigit(StringBuilder postfixExpression, char digit) {
        postfixExpression.append(digit);
    }

    private static void handleOperator(StringBuilder postfixExpression, Deque<Operator> operatorStack, char symbol) {
        Operator currentOperator = Operator.findBySymbol(symbol);

        while (!operatorStack.isEmpty() && operatorStack.peek().isHigherPriorityThan(currentOperator)) {
            postfixExpression.append(operatorStack.pop().getSymbol());
        }
        operatorStack.push(currentOperator);
    }
}
