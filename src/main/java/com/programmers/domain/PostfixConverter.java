package com.programmers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    Stack<String> stack = new Stack<>();

    public List<String> convertInfixToPostfix(List<String> tokens) {
        List<String> postfix = new ArrayList<>();

        for (String token : tokens) {
            addTokenToPostfix(postfix, token);
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    void addTokenToPostfix(List<String> postfix, String token) {
        if (isNumeric(token)) {
            postfix.add(token);
            return;
        }

        while (!stack.isEmpty() && compareOperators(stack.peek(), token)) {
            postfix.add(stack.pop());
        }

        stack.push(token);
    }

    public boolean compareOperators(String op1, String op2) {
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
