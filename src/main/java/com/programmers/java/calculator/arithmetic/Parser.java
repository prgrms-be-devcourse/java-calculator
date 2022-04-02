package com.programmers.java.calculator.arithmetic;

import java.util.*;

public class Parser {
    private final Validator validator = new Validator();

//    public ArrayList<String> parseToToken(String expression) {
//        String[] result = expression.split("\\s+");
//        Stack<String> stack = new Stack<>();
//        ArrayList<String> token = new ArrayList<>();
//
//        for (int i = 0; i < result.length; i++) {
//            if (validator.isOperator(result[i])) {
//                if (stack.isEmpty())
//                    stack.push(result[i]);
//                else {
//                    if (validator.getPriority(stack.peek()) >= validator.getPriority(result[i]))
//                        token.add(stack.pop());
//                    stack.push(result[i]);
//                }
//            } else
//                token.add(result[i]);
//        }
//
//        while (!stack.isEmpty()){
//            token.add(stack.pop());
//        }
//
//        return token;
//    }

    public List<String> parseToToken(String expression) {
        String[] element = splitBySpace(expression);
        Deque<String> stack = new ArrayDeque<>();
        List<String> token = new ArrayList<>();

        for (int i = 0; i < element.length; i++) {
            if (validator.isOperator(element[i])) {
                if (stack.isEmpty())
                    stack.addLast(element[i]);
                else {
                    if (validator.getPriority(stack.getLast()) >= validator.getPriority(element[i])) {
                        token.add(stack.getLast());
                        stack.removeLast();
                    }
                    stack.addLast(element[i]);
                }
            } else {
                token.add(element[i]);
            }
        }

        while (!stack.isEmpty()){
            token.add(stack.getLast());
            stack.removeLast();
        }

        return token;
    }

    private String[] splitBySpace(String expression){
        return expression.split("\\s+");
    }

}
