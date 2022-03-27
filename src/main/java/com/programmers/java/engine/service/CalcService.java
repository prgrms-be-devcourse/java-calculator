package com.programmers.java.engine.service;


import java.util.Stack;

public class CalcService implements Function {
    public Long calculate(String[] postFixFormula) {
        Stack<Long> s = new Stack<>();
        Stack<Long> s2 = new Stack<>();

        int idx = 0;
        for (int i = 0; !postFixFormula[i].equals("^"); i++) {
            String str = postFixFormula[i];
            if (isStrDigit(str))
                s.push(Long.parseLong(str));
            else {
                Long b = s.pop();
                Long a = s.pop();
                s = calcArithmetic(a, b, str, s);
            }
            idx = i;
        }

        while (!s.isEmpty()) {
            s2.push(s.pop());
        }

        for (int i = idx + 2; i < postFixFormula.length; i++) {
            Long a = s2.pop();
            Long b = s2.pop();
            s2 = calcArithmetic(a, b, postFixFormula[i], s2);
        }
        return s2.pop();
    }

    public Stack<Long> calcArithmetic(Long a, Long b, String str, Stack<Long> s) {
        switch (str) {
            case "+" -> s.push(a + b);
            case "-" -> s.push(a - b);
            case "/" -> s.push(a / b);
            case "*" -> s.push(a * b);
        }
        return s;
    }
}
