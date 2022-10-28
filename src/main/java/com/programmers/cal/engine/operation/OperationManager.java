package com.programmers.cal.engine.operation;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.PostfixExpression;
import com.programmers.cal.engine.postfix.Postfix;

import java.beans.Expression;
import java.util.List;
import java.util.Stack;

public class OperationManager implements Operation {

    private Postfix postfix;

    @Override
    public Answer calculate(PostfixExpression postfixTokens) {
        Stack<String> stack = new Stack<>();

        for (String token : postfixTokens.getPostfixTokens()) {
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

        return Answer.builder()
                .answer(stack.pop())
                .build();
    }
}