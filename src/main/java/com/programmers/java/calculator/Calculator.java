package com.programmers.java.calculator;

import com.programmers.java.util.OperandChecker;

import java.util.Stack;

public class Calculator {
    public double calculate(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();
        double result;
        Operator operator;

        for (String value : postfixExpression.split(" ")) {
            if (OperandChecker.isOperand(value)) {
                operandStack.push(Double.parseDouble(value));
                continue;
            }
            double nextOperand = operandStack.pop();
            double prevOperand = operandStack.pop();

            operator = Operator.valueOf(value);
            result = operator.calculate(prevOperand, nextOperand);
            operandStack.push(result);
        }
        result = operandStack.pop();

        return result;
    }
}