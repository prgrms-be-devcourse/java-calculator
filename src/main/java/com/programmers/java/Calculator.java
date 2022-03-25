package com.programmers.java;
import java.util.*;

public class Calculator {

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public boolean invalidCheck(StringTokenizer s) {
        if (s.hasMoreElements())
            return false;
        for (int i = 0; s.hasMoreElements(); i++) {
            String str = s.nextToken();
            if (i % 2 == 1) {
                if (str.length() > 1 || !isOperator(str.charAt(0)))
                    return false;
            } else {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(0) == '-') {
                        if (str.length() <= 1)
                            return false;
                    } else if (!isDigit(str.charAt(j)))
                        return false;
                }
            }
        }
        return true;
    }

    public String PostFixForm(StringTokenizer s) {
        Map<String, Integer> OperatorPriority = new HashMap<>();
        OperatorPriority.put("+", 2);
        OperatorPriority.put("-", 2);
        OperatorPriority.put("*", 1);
        OperatorPriority.put("/", 1);

        Stack<String> Operator = new Stack<>();
        Queue<String> tmp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; s.hasMoreElements(); i++) {
            String str = s.nextToken();
            if (i % 2 == 0) sb.append(str);
            else {
                if (Operator.isEmpty()) Operator.push(str);
                else {
                    while (true) {
                        int beforeOperator = OperatorPriority.get(Operator.peek());
                        if (OperatorPriority.get(str) < beforeOperator) {
                            sb.append(s.nextToken());
                            sb.append(str);
                            i += 1;
                        }
                        else if (beforeOperator < OperatorPriority.get(str)){
                            sb.append(Operator.pop());
                            Operator.push(str);
                        }
                        else {
                            while (!Operator.isEmpty() && OperatorPriority.get(Operator.peek()) < OperatorPriority.get(str)) {
                                tmp.add(Operator.pop());
                            }
                            Operator.push(str);
                            while (!tmp.isEmpty()) {
                                Operator.push(tmp.poll());
                            }
                        }
                        break;
                    }
                }
            }
        }
        while (!Operator.isEmpty()) sb.append(Operator.pop());
        return sb.toString();
    }

    public int Calc(String formula) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            if(isDigit(formula.charAt(i)))
                s.push(formula.charAt(i) - '0');
            else {
                int b = s.pop();
                int a = s.pop();
                switch (formula.charAt(i)) {
                    case '+' : s.push(a + b);
                        break;
                    case '-' : s.push(a - b);
                        break;
                    case '/' : s.push(a / b);
                        break;
                    case '*' : s.push(a * b);
                        break;
                }
            }
        }
        return s.pop();
    }
}

