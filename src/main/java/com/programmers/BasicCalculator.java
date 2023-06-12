package com.programmers;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator {
    public String doCalculate(String expression) {
        int answer = toPostfix(expression);
        System.out.println(answer);
        return expression + " = " + String.valueOf(answer);
    }

    private int getPriority(String operator) {
        if (operator.equals("(")) return 0;
        else if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }

    private int toPostfix(String str) {
        String[] strArr = str.split(" ");
        ArrayList<String> output = new ArrayList<>();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < strArr.length; i++) {
            String now = strArr[i];
            switch (now) {
                case "(" -> st.push(now);
                case ")" -> {
                    while (!st.isEmpty()) {
                        if (st.peek().equals("(")) {
                            st.pop();
                            break;
                        }
                        output.add(st.pop());
                    }
                }
                case "+", "-", "*", "/" -> {
                    while (!st.isEmpty() && getPriority(st.peek()) >= getPriority(now)) {
                        output.add(st.pop());
                    }
                    st.push(now);
                }
                default -> output.add(now);
            }
        }
        while (!st.isEmpty()) output.add(st.pop());
        return getResult(output);
    }

    public int getResult(ArrayList<String> list) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            String now = list.get(i);

            if (!now.equals("+") && !now.equals("-") && !now.equals("*") && !now.equals("/")){
                st.push(Integer.parseInt(now));
            } else {
                int x = st.pop();
                int y = st.pop();
                switch (now) {
                    case "+" -> st.push(y + x);
                    case "-" -> st.push(y - x);
                    case "*" -> st.push(y * x);
                    case "/" -> st.push(y / x);
                }
            }
        }
        return st.pop();
    }
}
