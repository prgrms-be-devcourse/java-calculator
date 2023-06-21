package com.programmers.java.calculator.util;

import com.programmers.java.calculator.domain.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixExpressionConverter implements Converter<String, Deque<String>> {

    Deque<Operator> stack = new ArrayDeque<>();
    Deque<String> postfix = new ArrayDeque<>();

    public Deque<String> convert(String expression) {
        String[] exp = expression.split(" ");

        for (String str : exp) {
            insertOperand(str);
            insertOperator(str);
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop().getSymbol());
        }

        return postfix;
    }

    private void insertOperand(String str) {
        if (Operator.isNumeric(str)) {
            postfix.add(str);
        }
    }

    private void insertOperator(String str) {
        if (!Operator.isOperator(str)) {
            return;
        }
        Operator newOperator = Operator.of(str);

        while (!stack.isEmpty() && compareOperator(stack, newOperator)) {
            postfix.add(stack.pop().getSymbol());
        }

        stack.push(newOperator);
    }

    private static boolean compareOperator(Deque<Operator> stack, Operator newOperator) {
        Operator preOperator = stack.peek();
        if (preOperator.comparePriority(newOperator) == 1) {
            return false;
        }

        return true;
    }
}
