package com.programmers.cal.engine.postfix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixManager implements Postfix{

    private int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }

    @Override
    public List<String> toPostfix(List<String> tokens) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();

        for (String element : tokens) {

            if (Character.isDigit(element.charAt(element.length() - 1))) {
                postfix.add(element);
            } else {

                while (!stack.isEmpty() && getPriority(element) <= getPriority(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(element);
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }
}
