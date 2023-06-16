package com.devcourse.engine.model.computer;

import com.devcourse.engine.model.Operator;

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
            stack.push(
                    Operator.getOperator(expression).calculate(
                            stack.pop(), stack.pop()
                    )
            );
            return;
        }
        stack.push(Double.parseDouble(expression));
    }
}
