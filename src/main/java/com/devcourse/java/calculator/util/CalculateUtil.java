package com.devcourse.java.calculator.util;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CalculateUtil {

    private CalculateUtil() {}

    public static String calculateAndReturnEquationWithAnswer(String equation) {
        String postfix = changeToPostfix(equation);
        String calculateAnswer = calculatePostfix(postfix);
        return equation + " = " + calculateAnswer;
    }

    private static int getPriority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static String changeToPostfix(String equation) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char each: equation.toCharArray()) {
            int priority = getPriority(each);

            if (isOperator(each)) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                    stringBuilder.append(stack.pop());
                    stringBuilder.append(' ');
                }
                stack.push(each);
            } else {
                stringBuilder.append(each);
            }
        }

        while (!stack.isEmpty()) {
            if (!Character.isDigit(stack.peek())) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString().replace("  ", " ");
    }

    private static boolean isOperator(char each) {
        return each == '+' || each == '-' || each == '*' || each == '/';
    }

    public static String calculatePostfix(String postfix) {
        Stack<Integer> operandStack = new Stack<>();
        String[] splitPostfix = postfix.split(" ");

        for (String each: splitPostfix) {

            if (each.matches("^?\\d*$")) {
                operandStack.push(Integer.parseInt(each));
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result = 0;

                switch (each.charAt(0)) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException(ExceptionMessageConstant.DIVIDE_BY_ZERO_EXCEPTION);
                        }
                        result = operand1 / operand2;
                        break;
                }

                operandStack.push(result);
            }
        }

        return String.valueOf(operandStack.pop());
    }

}
