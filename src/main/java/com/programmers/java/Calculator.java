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
        if(s.hasMoreElements())
            return false;
        for (int i = 0; s.hasMoreElements(); i++) {
            String str = s.nextToken();
            if (i % 2 == 1) {
                if (str.length() > 1 || !isOperator(str.charAt(0)))
                    return false;
            }
            else {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(0) == '-') {
                        if (str.length() <= 1)
                            return false;
                    }
                    else if (!isDigit(str.charAt(j)))
                        return false;
                }
            }
        }
        return true;
    }

    public String PostFixForm(StringTokenizer s) {
        Map<String, Integer> OperatorPriority = new HashMap<>();
        OperatorPriority.put("+",2);
        OperatorPriority.put("-",2);
        OperatorPriority.put("*",1);
        OperatorPriority.put("/",1);

        Stack<String> Operator = new Stack<>();
        Queue<String> tmp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; s.hasMoreElements() ; i++) {
            String str = s.nextToken();
            if (i % 2 == 0) sb.append(str);
            else {
                if (Operator.isEmpty()) Operator.push(str);
                else {
                    while (true) {
                        int beforeOperator = OperatorPriority.get(Operator.peek());
                        if (OperatorPriority.get(str) == beforeOperator || OperatorPriority.get(str) < beforeOperator) Operator.push(str);
                        else {
                            while (!Operator.isEmpty() && OperatorPriority.get(Operator.peek()) < OperatorPriority.get(str)) {
                                tmp.add(Operator.pop());
                            }
                            Operator.push(str);
                            while (!tmp.isEmpty()) Operator.push(tmp.poll());
                        }
                        break;
                    }
                }
            }
        }
        sb.append(" ");
        while (!Operator.isEmpty()) sb.append(Operator.pop());
        return sb.toString();
    }
}

