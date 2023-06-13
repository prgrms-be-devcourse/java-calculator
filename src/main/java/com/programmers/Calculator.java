package com.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public int calculate(String postfixExpression) {
        Deque<Integer> operandStack = new ArrayDeque<>();

        postfixExpression.chars()
                .mapToObj(token -> (char) token)
                .forEach(token -> {
                    if (Character.isDigit(token)) {
                        handleDigit(operandStack, token);
                    } else {
                        handleOperator(operandStack, token);
                    }
                });

        return operandStack.pop();
    }

    private static void handleDigit(Deque<Integer> operandStack, char digit) {
        int operand = Character.getNumericValue(digit);
        operandStack.push(operand);
    }

    private static void handleOperator(Deque<Integer> operandStack, char symbol) {
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();

        Operator operator = Operator.findBySymbol(symbol);
        int result = operator.calculate(operand1, operand2);

        operandStack.push(result);
    }
}
