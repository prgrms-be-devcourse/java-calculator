package com.programmers.cal.engine.operation;

import java.util.List;
import java.util.Stack;

public class OperationManager implements Operation {

    @Override
    public String calculate(List<String> postfixTokens) {
        Stack<String> stack = new Stack<>();

        for (String token : postfixTokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                stack.push(token);
            } else {
                if (stack.size() < 2) break;
                double second = Double.parseDouble(stack.pop());
                double first = Double.parseDouble(stack.pop());

                if (token.equals("/") && second == 0) throw new ArithmeticException("0으로 나눌 수 없음");

                switch (token) {
                    case "+":
                        stack.push(String.valueOf(first + second));
                        break;
                    case "-":
                        stack.push(String.valueOf(first - second));
                        break;
                    case "*":
                        stack.push(String.valueOf(first * second));
                        break;
                    case "/":
                        stack.push(String.valueOf(first / second));
                        break;
                }
            }
        }

        return stack.pop();
    }
}