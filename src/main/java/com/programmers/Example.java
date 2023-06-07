package com.programmers;

import java.util.Stack;

public class Example {
    public static int calculate(String str) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String now = Character.toString(str.charAt(i));

            if (!now.equals("+") && !now.equals("-") && !now.equals("*") && !now.equals("/")) {
                st.push(Integer.parseInt(now));
            } else {
                int x = st.pop();
                int y = st.pop();

                switch (now) {
                    case "+":
                        st.push(y + x);
                        break;
                    case "-":
                        st.push(y - x);
                        break;
                    case "*":
                        st.push(y * x);
                        break;
                    case "/":
                        st.push(y / x);
                        break;
                }
            }
        }
        return st.pop();
    }
    public static int priority(String operator) {
        if (operator.equals("(")) return 0;
        else if (operator.equals("+") || operator.equals("-")) return 1;
        else return 2;
    }
    public static int toPostfix(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String now = Character.toString(str.charAt(i));
            switch (now) {
                case "(":
                    st.push(now);
                    break;
                case ")": // ) -> 여는 괄호가 나올 때까지 출력큐에 넣어주고 여는 괄호 삭제
                    while (!st.isEmpty()) {
                        if (st.peek().equals("(")) {
                            st.pop();
                            break;
                        }
                        sb.append(st.pop());
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    // 연산자를 스택에 넣으려 할 때 이미 현재꺼보다 우선순위가 높거나 같은 게 있다면 빼줌
                    // 이후 스택에 현재 연산자 넣음
                    while (!st.isEmpty() && priority(st.peek()) >= priority(now)) {
                        sb.append(st.pop());
                    }
                    st.push(now);
                    break;
                default:
                    sb.append(now);
            }

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return calculate(sb.toString());
    }
    public static void main(String[] args) {
        System.out.println(toPostfix("1+2*3+(4+2)/2"));
    }
}