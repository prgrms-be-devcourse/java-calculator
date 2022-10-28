package com.programmers.java.calculator.parser;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostFixParser implements Parser {
    public String parse(String exp) {
        ArrayList<String> postFix = new ArrayList<>();
        String[] s = exp.split("");
        Stack<String> stack = new Stack<>();

        for (String t : s) {
            if (isNum(t)) {
                postFix.add(t);
            } else {
                if (t.equals("(")) stack.push(t);
                else if (t.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postFix.add(" " + stack.pop() + " ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && hasPriority(stack.peek())) {
                        postFix.add(" " + stack.pop() + " ");
                    }
                    stack.push(t);
                    postFix.add(" ");
                }
            }
        }
        while (!stack.isEmpty()) {
            postFix.add(" " + stack.pop() + " ");
        }
        return String.join("", postFix);
    }

    private boolean hasPriority(String o) {
        return o.equals("*") || o.equals("/");
    }
}
