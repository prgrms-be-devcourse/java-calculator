package com.devcourse.engine.computer;

import com.devcourse.engine.model.Operator;

import java.util.List;
import java.util.Stack;

public class SimpleComputer implements Computer {

    public double compute(List<String> expression) {
        Stack<Double> stack = new Stack<>();
        for (String exp : expression) {
            branchIsOperator(exp, stack);
        }
        return stack.pop();
    }

    private void branchIsOperator(String exp, Stack<Double> stack) {
        if (Operator.isOperator(exp))
            stack.push(
                    Operator.getOperator(exp).calculate(
                            stack.pop(), stack.pop()
                    )
            );
        else
            stack.push(Double.parseDouble(exp));
    }
}
