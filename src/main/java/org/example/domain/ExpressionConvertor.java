package org.example.domain;

import java.util.ArrayList;
import java.util.Stack;

public class ExpressionConvertor {
    public String[] convertToPostfix(String infix) {
        boolean isBracket = false;

        if (infix.charAt(0) == '(') {
            isBracket = true;
        }

        infix = trimSpaces(infix);
        String[] str = splitBySpaces(infix);

        ArrayList<String> sb = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            String now = str[i];

            switch (now){
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.add(stack.pop());
                    }
                    stack.push(now);
                    break;
                case "(":
                    stack.push(now);
                    break;
                case ")":
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        sb.add(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.add(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.add(stack.pop());
        }

        if(isBracket) {
            sb.remove(0);}

        String[] result = new String[sb.size()];

        for(int i = 0; i < sb.size(); i++) {
            result[i]=sb.get(i);
        }

        return result;
    }

    private String trimSpaces(String infix) {
        infix = infix.replace("(", " ( ")
                .replace(")", " ) ")
                .replace("+", " + ")
                .replace("-", " - ")
                .replace("/", " / ")
                .replace("*", " * ")
                .replace("  ", " ");

        return infix;
    }

    private String[] splitBySpaces(String infix) {
        return infix.split(" ");
    }

    private int priority(String operator) {

        if (operator.equals("(") || operator.equals(")")) {
            return 0;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }

        return -1;
    }
}
