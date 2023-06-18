package com.programmers.calculator.util;

import com.programmers.calculator.domain.Operator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PostfixConverter {
    public static String convert(String expression) {
        StringBuilder postfixExpression = new StringBuilder();
        Deque<Operator> operatorStack = new ArrayDeque<>();

        Arrays.stream(expression.split(" "))
                .forEach(token -> {
                    if (Character.isDigit(token.charAt(0))) {
                        appendToken(postfixExpression, token);
                    }
                    if (Operator.isOperator(token)) {
                        handleOperator(postfixExpression, operatorStack, token);
                    }
                });

        while (!operatorStack.isEmpty()) {
            appendToken(postfixExpression, operatorStack.pop().getSymbol());
        }
        return postfixExpression.toString().trim();
    }

    private static void handleOperator(StringBuilder postfixExpression, Deque<Operator> operatorStack, String symbol) {
        Operator currentOperator = Operator.findBySymbol(symbol);

        while (!operatorStack.isEmpty() && operatorStack.peek().isHigherPriorityThan(currentOperator)) {
            appendToken(postfixExpression, operatorStack.pop().getSymbol());
        }
        operatorStack.push(currentOperator);
    }

    private static void appendToken(StringBuilder postfixExpression, String token) {
        postfixExpression.append(token).append(" ");
    }
}
