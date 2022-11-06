package com.programmers.java.calculator;

import com.programmers.java.exception.DivideByZeroException;

import java.util.Stack;

import static com.programmers.java.pattern.RegexPattern.NUMBER;
import static com.programmers.java.pattern.RegexPattern.OPERATOR;

public class PostfixCalculator implements Calculator {
    private static final Stack<String> stack = new Stack<>();
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";


    @Override
    public double calculate(String expression) throws ArithmeticException {
        for (String token : convertInfix2Postfix(expression).split(" ")) {
            if (isNumeric(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());
                stack.push(
                        String.valueOf(operateTwoNum(a, b, token)
                        ));
            }
        }
        return Double.parseDouble(stack.pop());
    }

    private double operateTwoNum(double num1, double num2, String token) {
        switch (token) {
            case PLUS:
                return num2 + num1;
            case MINUS:
                return num2 - num1;
            case MULTIPLICATION:
                return num2 * num1;
            case DIVISION:
                if (num1 == 0) {
                    throw new DivideByZeroException();
                }
                return num2 / num1;
            default:
                throw new IllegalStateException("Unexpected value: " + token);
        }
    }

    private String convertInfix2Postfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        for (String token : infixExpression.split(" ")) {
            if (isNumeric(token)) {
                postfixExpression.append(token).append(" ");
            } else if (OPEN_PARENTHESIS.equals(token)) {
                stack.push(token);
            } else if (CLOSE_PARENTHESIS.equals(token)) {
                while (true) {
                    String cur = stack.pop();
                    if (OPEN_PARENTHESIS.equals(cur)) {
                        break;
                    }
                    postfixExpression.append(cur).append(" ");
                }
            } else if (isOperator(token)) {
                if (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(token)) {
                    postfixExpression.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop()).append(" ");
        }

        return postfixExpression.toString();
    }

    private boolean isOperator(String unit) {
        return unit.matches(OPERATOR.getPattern());
    }

    private boolean isNumeric(String number) {
        return number.matches(NUMBER.getPattern());
    }

    private int getPriority(String sign) {
        return switch (sign) {
            case PLUS, MINUS -> 1;
            case MULTIPLICATION, DIVISION -> 2;
            default -> -1;
        };
    }
}
