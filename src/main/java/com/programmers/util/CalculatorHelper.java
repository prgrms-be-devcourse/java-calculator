package com.programmers.util;

import java.util.Stack;

public class CalculatorHelper {
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("연산자를 확인해주세요.");
        }
    }

}
