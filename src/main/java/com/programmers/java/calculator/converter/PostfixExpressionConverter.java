package com.programmers.java.calculator.converter;

import com.programmers.java.calculator.model.Operator;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixExpressionConverter implements Converter<String, String> {

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    private static boolean isNumeric(String strNum) {
        return pattern.matcher(strNum).matches();
    }

    public String convert(String expression) {
        String[] exp = expression.split(" ");
        Stack<Operator> waiting = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (String str : exp) {
            if (isNumeric(str)) {
                postfix.push(str);
                continue;
            }

            Operator operator = Operator.of(str);

            while (isSameOrHighPriority(waiting, operator)) {
                postfix.push(waiting.pop().getSymbol());
            }

            waiting.push(operator);
        }

        while (!waiting.isEmpty())
            postfix.add(waiting.pop().getSymbol());

        return calculatePostfix(postfix);
    }

    private static boolean isSameOrHighPriority(Stack<Operator> waiting, Operator operator) {
        return !waiting.isEmpty() && operator.comparePriority(waiting.peek()) == -1;
    }

    private String calculatePostfix(Stack<String> postfix) {
        Stack<String> stack = new Stack<>();

        while (!postfix.isEmpty()) {
            if (isNumeric(postfix.peek())) {
                stack.push(postfix.pop());
                continue;
            }

            Operator operator = Operator.of(postfix.pop());
            BigDecimal a = new BigDecimal(postfix.pop());
            BigDecimal b = new BigDecimal(postfix.pop());
            stack.push(String.valueOf(operator.calculate(b, a)));
        }

        BigDecimal result = new BigDecimal(stack.pop());
        return result.toString();
    }
}
