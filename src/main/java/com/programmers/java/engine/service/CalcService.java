package com.programmers.java.engine.service;


import com.programmers.java.engine.service.utils.Function;

import java.util.Stack;

public class CalcService {
    public Long calculate(String[] postFixFormula) {
        Stack<Long> s = new Stack<>();
        for (int i = 0; i < postFixFormula.length; i++) {
            String str = postFixFormula[i];
            if (!Function.isStrDigit(str)) {
                Long b = s.pop();
                Long a = s.pop();
                calcArithmetic(a, b, str, s);
            } else {
                s.push(Long.parseLong(str));
            }
        }
        return s.pop();
    }

    public Stack<Long> calcArithmetic(Long a, Long b, String str, Stack<Long> s) {
        switch (str) {
            case "+" -> s.push(a + b);
            case "-" -> s.push(a - b);
            case "/" -> s.push(a / b);
            case "*" -> s.push(a * b);
            default -> throw new IllegalStateException("Unexpected Operator: " + str);
        }
        return s;
    }
}
