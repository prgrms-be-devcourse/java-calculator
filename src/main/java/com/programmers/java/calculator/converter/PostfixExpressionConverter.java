package com.programmers.java.calculator.converter;

import com.programmers.java.calculator.model.Operator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

public class PostfixExpressionConverter implements Converter<String, String> {

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private static boolean isNumeric(String strNum) {
        return pattern.matcher(strNum).matches();
    }

    public String convert(String expression) {
        String[] exp = expression.split(" ");
        Deque<Operator> stack = new ArrayDeque<>();
        Deque<String> postfix = new ArrayDeque<>();

        for (String str : exp) {
            if (isNumeric(str)) {
                postfix.add(str);
                continue;
            }

            Operator newOperator = Operator.of(str);

            while (compareOperator(stack, newOperator)) {
                postfix.add(stack.pop().getSymbol());
            }

            stack.push(newOperator);
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop().getSymbol());
        }

        return calculatePostfix(postfix);
    }

    private static boolean compareOperator(Deque<Operator> stack, Operator newOperator) {
        if (stack.isEmpty()) {
            return false;
        }

        Operator preOperator = stack.peek();
        return preOperator.comparePriority(newOperator) != 1;
    }

    private String calculatePostfix(Deque<String> postfix) {
        Deque<String> stack = new ArrayDeque<>();

        while (!postfix.isEmpty()) {
            if (isNumeric(postfix.peek())) {
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
