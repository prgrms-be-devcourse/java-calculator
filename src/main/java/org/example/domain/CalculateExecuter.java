package org.example.domain;

import org.example.util.Operator;
import org.example.validate.Validater;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateExecuter {
    public Integer calculate(String[] str) {
        final Deque<Integer> stack = new ArrayDeque<>();

        for (String x : str) {

            if (Validater.isNumber(x)) {
                stack.push(Integer.parseInt(x));
            } else {
                int a = stack.pop();
                int b = stack.pop();

                Operator op = Operator.getOperator(x);
                stack.push(op.doCalculate(b, a));
            }
        }
        return stack.pop();
    }
}
