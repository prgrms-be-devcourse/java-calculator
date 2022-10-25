package org.programmers.java.calculator.model;

import lombok.AllArgsConstructor;

import java.util.*;

public class Formula {

    private String formula;

    public Formula(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            switch (now) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.add(now);
                    break;
                case '(':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

    }

    private static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    // 사용자 입력 유효 검사
    public boolean validate(String exp) {
        String[] s = exp.replace(" ", "").split("");
        List<String> operator = Arrays.asList("+", "-", "*", "/");
        boolean isOperator = false;
        boolean isDivide = false;
        Stack<Integer> bracket = new Stack<>();
        int countOperator = 0;
        int countNum = 0;

        if(operator.contains(s[0]) || operator.contains(s[s.length-1])) return false;

        for (String t : s) {
            if (t.matches("^[0-9]*$")) {
                if (t.equals("0") && isDivide) return false;
                isOperator = false;
                isDivide = false;
                countNum += 1;
            } else if (operator.contains(t)) {
                if (isOperator) {
                    return false;
                }
                isOperator = true;
                countOperator += 1;
                if (t.equals("/")) {
                    isDivide = true;
                }
            } else if (t.equals("(")) {
                bracket.add(1);
            } else if (t.equals(")")) {
                try {
                    bracket.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        if(countOperator >= countNum || countOperator == 0) return false;
        return bracket.isEmpty();
    }
}
