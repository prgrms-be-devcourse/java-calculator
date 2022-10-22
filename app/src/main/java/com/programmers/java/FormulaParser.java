package com.programmers.java;

import java.util.Stack;

public class FormulaParser {
    public String changeInfixToPostfix(String formula) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> formulaCharStack = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!formulaCharStack.isEmpty() && getPriority(formulaCharStack.peek()) >= getPriority(c)) {
                    stringBuilder.append(formulaCharStack.pop());
                }

                formulaCharStack.push(c);
            } else if (c == '(') {
                formulaCharStack.push(c);
            } else if (c == ')') {
                while (!formulaCharStack.isEmpty() && formulaCharStack.peek() != '(') {
                    stringBuilder.append(formulaCharStack.pop());
                }

                formulaCharStack.pop();
            } else {
                stringBuilder.append(c);
            }
        }

        while (!formulaCharStack.isEmpty()) {
            stringBuilder.append(formulaCharStack.pop());
        }

        return stringBuilder.toString();
    }

    public int getPriority(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '(' || operator == ')') {
            return 0;
        }

        return -1;
    }
}
