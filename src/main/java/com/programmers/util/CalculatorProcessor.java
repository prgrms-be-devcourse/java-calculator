package com.programmers.util;

import com.programmers.error.CalculatorException;

import java.util.Stack;

import static com.programmers.error.ErrorMessage.DIVIDE_ZERO_EXCEPTION;
import static com.programmers.error.ErrorMessage.NOT_VALID_ARITHMETIC_EXPRESSION;

public class CalculatorProcessor {
    public static int calculateExpression(String postfix) throws ArithmeticException {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = postfix.split("");

        for (String token : tokens) {
            //숫자인 경우 스택에 추가
            if (Character.isDigit(token.charAt(0))) {
                int operand = Validator.checkInteger(token);
                stack.push(operand);
            }
            //연산자인 경우 stack에서 필요한 피연산자들을 꺼내 연산을 수행하고 결과를 스택에 추가
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = performOperation(token, operand1, operand2);
                stack.push(result);

            }
        }
        return stack.pop();
    }

    public static int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new CalculatorException(DIVIDE_ZERO_EXCEPTION);
                }
                return operand1 / operand2;
            default:
                throw new CalculatorException(NOT_VALID_ARITHMETIC_EXPRESSION);
        }
    }

}
