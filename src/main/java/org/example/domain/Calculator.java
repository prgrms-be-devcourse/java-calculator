package org.example.domain;

import java.util.Stack;

import static org.example.domain.Validation.REGEX_NUM;

public class Calculator {

    public double calculate(String infixExpression) {
        String postfixExpression = toPostfix(infixExpression.split(" "));
        Stack<Double> operandStack = new Stack<>();

        for (String value : postfixExpression.split(" ")) {
            if (isNumber(value)) {
                operandStack.push(Double.parseDouble(value));
                continue;
            }
            double left = operandStack.pop();
            double right = operandStack.pop();
            CalculateType calculateType = CalculateType.findBySymbol(value);
            double midResult = calculateType.calculate(left, right);
            operandStack.push(midResult);
        }
        double result = operandStack.pop();
        return result;
    }

    private String toPostfix(String[] infixExpression) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (String value : infixExpression) {

            if (isNumber(value)) {
                postfixExpression.append(value + " ");
                continue;
            }

            CalculateType calculateType = CalculateType.findBySymbol(value);
            while (!operatorStack.isEmpty() &&
                    calculateType.getPriority() < CalculateType.findBySymbol(operatorStack.peek()).getPriority()) {
                postfixExpression.append(operatorStack.pop() + " ");
            }
            operatorStack.push(value);
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop() + " ");
        }
        return postfixExpression.toString();
    }

    private boolean isNumber(String value) {
        if (REGEX_NUM.matcher(value).matches()) {
            return true;
        }
        return false;
    }
}
