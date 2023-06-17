package org.example.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ExpressionConvertor {
    public String[] convertToPostfix(String infix) {
        infix = removeSpaces(infix);
        String[] str = splitBySpaces(infix);

        ArrayList<String> sb = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length; i++) {
            String now = str[i];

            switch (now) {
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.add(stack.pop());
                    }
                    stack.push(now);
                    break;
                case "(":
                    stack.push(now);
                    break;
                case ")":
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        sb.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.add(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.add(stack.pop());
        }

        String[] result = new String[sb.size()];

        for (int i = 0; i < sb.size(); i++) {
            result[i] = sb.get(i);
        }

        return result;
    }

    private String removeSpaces(String infix) {
        infix = infix.replace(" ", "")
                .replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("/", " / ")
                .replace("*", " * ")
                .replace("  ", " ")
                .trim();
        return infix;
    }

    private String[] splitBySpaces(String infix) {
        return infix.split(" ");
    }

    private int priority(String operator) {

        if (operator.equals("(") || operator.equals(")")) {
            return 0;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }

        return -1;
    }
}
