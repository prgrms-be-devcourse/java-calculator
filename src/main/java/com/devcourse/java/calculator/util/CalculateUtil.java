package com.devcourse.java.calculator.util;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import com.devcourse.java.calculator.validator.TypeValidator;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateUtil {

    private CalculateUtil() {}

    public static String calculateAndReturnAnswer(String equation) {
        String postfix = changeToPostfix(equation);
        return calculatePostfix(postfix);
    }

    public static String changeToPostfix(String equation) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (String each: equation.split(" ")) {
            if (TypeValidator.isOperator(each)) {

                while (!stack.isEmpty() && Operation.getOperationPriority(stack.peek()) >= Operation.getOperationPriority(each)) {
                    stringBuilder.append(stack.pop());
                    stringBuilder.append(" ");
                }
                stack.push(each);
            } else {
                stringBuilder.append(each);
                stringBuilder.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            if (!TypeValidator.isInteger(stack.peek())) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString().replace("  ", " ");
    }

    public static String calculatePostfix(String postfix) {
        Deque<Double> operandStack = new ArrayDeque<>();
        String[] splitPostfix = postfix.split(" ");

        for (String each: splitPostfix) {

            if (TypeValidator.isInteger(each)) {
                operandStack.push(Double.parseDouble(each));
            } else {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = 0;

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
