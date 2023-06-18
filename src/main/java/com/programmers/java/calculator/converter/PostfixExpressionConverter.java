package com.programmers.java.calculator.converter;

import com.programmers.java.calculator.model.Operator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixExpressionConverter implements Converter<String, String> {

    Deque<Operator> stack = new ArrayDeque<>();
    Deque<String> postfix = new ArrayDeque<>();

    public String convert(String expression) {
        String[] exp = expression.split(" ");

        for (String str : exp) {
            insertOperand(str);
            insertOperator(str);
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop().getSymbol());
        }

        return calculatePostfix(postfix);
    }

    private void insertOperand(String str) {
        if (Operator.isNumeric(str)) {
            postfix.add(str);
        }
    }

    private void insertOperator(String str) {
        Operator newOperator = Operator.of(str);

        while (compareOperator(stack, newOperator)) {
            postfix.add(stack.pop().getSymbol());
        }

        stack.push(newOperator);
    }

    private static boolean compareOperator(Deque<Operator> stack, Operator newOperator) {
        if (stack.isEmpty()) {
            return false;
        }

        Operator preOperator = stack.peek();
        if (preOperator.comparePriority(newOperator) == 1) {
            return false;
        }

        return true;
    }

    private String calculatePostfix(Deque<String> postfix) {
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
