package org.example.domain;

import java.util.Stack;

public class Expression {
    public String convertToPostfix(String infix) {
        boolean isBracket = false;

        if (infix.charAt(0) == '(') {
            isBracket = true;
        }

        infix = trimSpaces(infix);
        String[] str = splitBySpaces(infix);

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            String now = str[i];

            switch (now) {
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.push(now);
                    break;
                case "(":
                    stack.push(now);
                    break;
                case ")":
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        if (isBracket) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    private String trimSpaces(String infix) {
        infix = infix.replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("/", " / ")
                .replace("*", " * ")
                .replace("  ", " ");

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
