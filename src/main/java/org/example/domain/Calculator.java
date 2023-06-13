package org.example.domain;

import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {

    private final Pattern REGEX_NUM = Pattern.compile("[0-9]+");

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
            dividedZero(value, right);

            CalculateType calculateType = CalculateType.findBySymbol(value);
            double midResult = calculateType.calculate(left, right);
            operandStack.push(midResult);
        }

        double result = operandStack.pop();

        return result;
    }

    private void dividedZero(String value, double right) {
        if (value.equals("/") && right == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
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
            int op1Priority = CalculateType.findBySymbol(operatorStack.peek()).getPriority();
            int op2Priority = calculateType.getPriority();
            while (!operatorStack.isEmpty() && op1Priority < op2Priority) {
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
        return REGEX_NUM.matcher(value).matches();
    }

}
