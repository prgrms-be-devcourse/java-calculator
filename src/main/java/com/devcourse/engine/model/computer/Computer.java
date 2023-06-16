package com.devcourse.engine.model.computer;

import com.devcourse.engine.model.unit.Operator;

import java.util.List;
import java.util.Stack;

public class Computer {

    public double compute(List<String> expressions) {
        Stack<Double> stack = new Stack<>();
        for (String expression : expressions) {
            branchIsOperator(expression, stack);
        }
        return stack.pop();
    }

    private void branchIsOperator(String expression, Stack<Double> stack) {
        if (Operator.isOperator(expression)) {
            stack.push(getCalculationResult(expression, stack));
            return;
        }
        stack.push(Double.parseDouble(expression));
    }

    private Double getCalculationResult(String expression, Stack<Double> stack) {
        return Operator.getOperator(expression).calculate(stack.pop(), stack.pop());
    }
}
