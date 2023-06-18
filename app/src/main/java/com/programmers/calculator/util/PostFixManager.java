package com.programmers.calculator.util;

import com.programmers.calculator.model.Operator;

import java.util.Stack;

public class PostFixManager {
    public static int calculate(String postFixString) {
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < postFixString.length(); i++) {
            char c = postFixString.charAt(i);
            if (Character.isDigit(c)) {
                numbers.add(Character.getNumericValue(c));
                continue;
            }
            Integer second = numbers.pop();
            Integer first = numbers.pop();

            switch (Operator.of(c)) {
                case PLUS -> numbers.push(first + second);
                case MINUS -> numbers.push(first - second);
                case MULTIPLY -> numbers.push(first * second);
                case DIVIDE -> numbers.push(first / second);
            }

        }
        return numbers.pop();
    }
}
