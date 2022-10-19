package com.programmers.calculator.util;

import java.util.*;

public class Parser {
    private static Parser parser;

    private Parser() {
    }

    public static Parser getInstance() {
        if (parser == null) {
            parser = new Parser();
        }
        return parser;
    }

    public String[] parse(String str) {
        return str.trim().replace(" ", "").split("(?<=[()*/+-])|(?=[()*/+-])");
    }

    public String[] getPostfix(String[] formula) {
        List<String> postfixList = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();

        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/", "(", ")"));

        for (String token : formula) {
            if (!operators.contains(token)) {
                postfixList.add(token);
            } else if (token.equals("(")) {
                operatorStack.add(token);
            } else if (token.equals(")")) {
                while (true) {
                    String temp = operatorStack.pop();
                    if (temp.equals("(")) {
                        break;
                    } else {
                        postfixList.add(temp);
                    }
                }
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(token);
                } else if (getPriority(operatorStack.peek()) < getPriority(token)) {
                    operatorStack.push(token);
                } else {
                    postfixList.add(operatorStack.pop());
                    while (!operatorStack.isEmpty()) {
                        if (!(getPriority(operatorStack.peek()) < getPriority(token))) {
                            break;
                        }
                        postfixList.add(operatorStack.pop());
                    }
                    operatorStack.push(token);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixList.add(operatorStack.pop());
        }

        return postfixList.toArray(new String[0]);
    }

    private int getPriority(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

}
