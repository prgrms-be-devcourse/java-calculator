package com.programmers.java.calculator.arithmetic;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Stack;

public class Parser {
    private final Validator validator = new Validator();

    public ArrayList<String> parseToToken(String expression) {
        String[] result = expression.split("\\s+");
        Stack<String> stack = new Stack<>();
        ArrayList<String> token = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            if (validator.isOperator(result[i])) {
                if (stack.isEmpty())
                    stack.push(result[i]);
                else {
                    if (validator.getPriority(stack.peek()) >= validator.getPriority(result[i]))
                        token.add(stack.pop());
                    stack.push(result[i]);
                }
            } else
                token.add(result[i]);
        }

        while (!stack.isEmpty()){
            token.add(stack.pop());
        }

        return token;
    }

}
