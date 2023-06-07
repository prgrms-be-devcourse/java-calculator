package com.programmers.domain;

import com.programmers.util.Arithmetic;

import java.util.Stack;

public class Calculator {
    public int calculate(String[] inputs) {
        Stack<Integer> numbers = new Stack<>();
        for (String input : inputs) {
            if(Arithmetic.isNumber(input)) {
                numbers.push(Integer.parseInt(input));
            } else {
                int result = binaryOperation(numbers.pop(), numbers.pop(), input);
                numbers.push(result);
            }
        }

        return numbers.pop();
    }

    private int binaryOperation(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                return b / a;
            default:
                throw new UnsupportedOperationException("올바른 연산자를 입력해주세요.");
        }
    }
}
