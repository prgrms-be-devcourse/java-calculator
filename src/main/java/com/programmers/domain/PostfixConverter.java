package com.programmers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    public List<String> convertInfixToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            if (isNumeric(token)) {
                postfix.add(token);
                continue;
            }

            while (!stack.isEmpty() && isProceed(stack.peek(), token)) {
                postfix.add(stack.pop());
            }

            stack.push(token);
        }

        while (!stack.isEmpty()) {
            postfix.add(String.valueOf(stack.pop()));
        }

        return postfix;
    }

    public boolean isProceed(String op1, String op2) {
        int op1Importance = Operator.findImportance(op1);
        int op2Importance = Operator.findImportance(op2);

        if (op1Importance >= op2Importance) {
            return true;
        }
        return false;
    }

    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
