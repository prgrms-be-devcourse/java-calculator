package com.programmers.java.calculator.domain.calculator;

import com.programmers.java.calculator.domain.Operator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixExpressionCalculator implements com.programmers.java.calculator.domain.calculator.Calculator<Deque<String>, String> {

    @Override
    public String calculate(Deque<String> postfix) {
        Deque<String> stack = new ArrayDeque<>();

        while (!postfix.isEmpty()) {
            if (Operator.isNumeric(postfix.peek())) {
                stack.push(postfix.poll());
                continue;
            }

            Operator operator = Operator.of(postfix.poll());
            BigDecimal a = new BigDecimal(stack.pop());
            BigDecimal b = new BigDecimal(stack.pop());
            stack.push(String.valueOf(operator.calculate(b, a)));
        }

        BigDecimal result = new BigDecimal(stack.pop());
        return result.toString();
    }
}
