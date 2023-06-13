package com.programmers.calculator.util;

import com.programmers.calculator.model.Operator;

import java.util.Stack;

public class Converter {

    public static boolean isValid(String input) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                if (!Character.isDigit(Integer.parseInt(strings[i]))) {
                    return false;
                }
            }
            if (i % 2 == 1) {
                if (!strings[i].matches("[+\\-*/]")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String getPostFixString(String expression) {
        StringBuilder sb = new StringBuilder();
        Stack<Operator> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isSpaceChar(c)) continue;
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }

            if (operators.empty()) {
                operators.push(Operator.of(c));
                continue;
            }

            if (Operator.compare(c, operators.peek()) > 0) {
                operators.push(Operator.of(c));
                continue;
            }

            if (Operator.compare(c, operators.peek()) <= 0) {
                while (!operators.isEmpty()) {
                    if (Operator.compare(c, operators.peek()) <= 0) {
                        sb.append(operators.pop().get());
                    }
                }
                operators.push(Operator.of(c));
            }

        }
        while (!operators.isEmpty()) {
            sb.append(operators.pop().get());
        }

        return sb.toString();
    }
}
