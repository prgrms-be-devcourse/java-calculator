package com.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public double calculate(String postfixExpression) {
        Deque<Double> operandStack = new ArrayDeque<>();

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

    private static void handleDigit(Deque<Double> operandStack, char digit) {
        double operand = Character.getNumericValue(digit);
        operandStack.push(operand);
    }

    private static void handleOperator(Deque<Double> operandStack, char symbol) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();

        Operator operator = Operator.findBySymbol(symbol);
        double result = operator.calculate(operand1, operand2);

        operandStack.push(result);
    }
}
