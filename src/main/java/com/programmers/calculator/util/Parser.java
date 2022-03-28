package com.programmers.calculator.util;

import java.util.*;

public class Parser {
    public static String[] parse(String str) {
        return str.trim().replace(" ", "").split("(?<=[()*/+-])|(?=[()*/+-])");
    }

    public static int opcode(String op) {
        switch (op) {
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

    public static String[] makePostfix(String[] formula) {
        Set<String> operationCode = new HashSet<>(Arrays.asList("+", "-", "*", "/", "(", ")"));
        ArrayList<String> postfixList = new ArrayList<>();
        Stack<String> opStack = new Stack<>();

        for (String token : formula) {
            if (!operationCode.contains(token)) {
                postfixList.add(token);
            } else if (token.equals("(")) {
                opStack.add(token);
            } else if (token.equals(")")) {
                while (true) {
                    String temp = opStack.pop();
                    if (temp.equals("(")) {
                        break;
                    } else {
                        postfixList.add(temp);
                    }
                }
            } else {
                if (opStack.isEmpty()) {
                    opStack.push(token);
                } else if (opcode(opStack.peek()) < opcode(token)) {
                    opStack.push(token);
                } else {
                    postfixList.add(opStack.pop());
                    while (!opStack.isEmpty()) {
                        if (!(opcode(opStack.peek()) < opcode(token))) {
                            break;
                        }
                        postfixList.add(opStack.pop());
                    }
                    opStack.push(token);
                }
            }
        }

        while (!opStack.isEmpty()) {
            postfixList.add(opStack.pop());
        }

        return postfixList.toArray(new String[0]);
    }
}
