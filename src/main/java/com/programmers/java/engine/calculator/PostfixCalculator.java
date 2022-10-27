package com.programmers.java.engine.calculator;

import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.util.Operator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PostfixCalculator implements Calculator<Integer> {
    @Override
    public Integer calculate(Expression expression) {
        Deque<Double> deque = new ArrayDeque<>();
        List<String> tokens = Arrays.asList(expression.toString().trim().split(" "));

        tokens.stream()
                .forEach(token -> {
                    if (token.matches("[0-9]+")) {
                        deque.push(Double.parseDouble(token));
                    } else {
                        Operator operator = Operator.findOperator(token);

                        double y = deque.pollFirst();
                        double x = deque.pollFirst();
                        deque.addFirst((double) operator.calculate(x, y));
                    }
                });

        return deque.pop().intValue();
    }
}
