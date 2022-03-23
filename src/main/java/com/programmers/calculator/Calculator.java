package com.programmers.calculator;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    static Map<String, Integer> expressionResult = new LinkedHashMap<>();

    static void calc(String expression) {
        List<String> postfix = infixToPostfix(expression);
        if(postfix == null) {
            System.out.println("잘못된 수식");
            return;
        }

        Stack<String> stack = new Stack<>();
        for(String s : postfix) {
            if(Pattern.matches(Regex.num, s)) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(s.equals("+") ? Integer.toString(num1 + num2) :
                           s.equals("-") ? Integer.toString(num1 - num2) :
                           s.equals("*") ? Integer.toString(num1 * num2) :
                                           Integer.toString(num1 / num2));
            }
        }

        int answer = Integer.parseInt(stack.pop());
        expressionResult.put(expression, answer);

        System.out.println(answer);
    }

    static void show() {

    }

    static List<String> infixToPostfix(String infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] numsNSymbols = infix.split(" ");
        for(String s : numsNSymbols) {
            if (Pattern.matches(Regex.num, s)) {
                postfix.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    if (Priority.getPriority(stack.peek()) >= Priority.getPriority(s)) {
                        postfix.add(stack.pop());
                        stack.push(s);
                    } else {
                        stack.push(s);
                    }
                }
            } else if (s.equals(")")) {
                while(true) {
                    String tmp = stack.pop();
                    if(tmp.equals("(")) break;
                    postfix.add(tmp);
                }
            } else {
                return null;
            }
        }

        while(!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }
}
