package com.wonu606.calculator.calculator;

import com.wonu606.calculator.model.Operator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class PostfixCalculator implements Calculator {

    @Override
    public double calculate(List<String> postfixExpression) {
        Deque<Double> operandStack = new ArrayDeque<>();

        for (String token : postfixExpression) {
            handleToken(operandStack, token);
        }

        return operandStack.pop();
    }

    private void handleToken(Deque<Double> operandStack, String token) {
        if (isOperator(token)) {
            Operator operator = Objects.requireNonNull(Operator.get(token));
            performOperation(operandStack, operator);
            return;
        }
        operandStack.push(Double.valueOf(token));
    }

    private void performOperation(Deque<Double> operandStack, Operator operator) {
        double secondOperand = operandStack.pop();
        double firstOperand = operandStack.pop();

        double result = operator.apply(firstOperand, secondOperand);
        operandStack.push(result);
    }

    private boolean isOperator(String token) {
        return Operator.get(token) != null;
    }
}
