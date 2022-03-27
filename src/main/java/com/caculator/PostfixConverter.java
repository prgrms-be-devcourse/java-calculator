package com.caculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    public static List<String> convert(String exp) throws IllegalArgumentException {
        List<String> postfix = new ArrayList<>();
        String[] split = exp.split(" ");
        Stack<String> stack = new Stack<>();

        if (split.length == 0) throw new IllegalArgumentException("올바른 수식이 아닙니다");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (isIdxForOperator(i)) {
                if (!(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-"))) {
                    throw new IllegalArgumentException();
                }

                if (stack.isEmpty() || getPriority(stack.peek()) < getPriority(s)) {
                    stack.push(s);
                    continue;
                }

                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(s)) {
                    postfix.add(stack.pop());
                }

                stack.push(s);
            } else {
                if (!StringUtils.isNumber(s)) {
                    throw new IllegalArgumentException("올바른 수식이 아닙니다");
                }
                postfix.add(s);
            }
        }

        while (!stack.isEmpty()) postfix.add(stack.pop());

        return postfix;
    }

    private static boolean isIdxForOperator(int index) {
        return (index + 1) % 2 == 0;
    }

    private static int getPriority(String op) {
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return -1;
    }
}
