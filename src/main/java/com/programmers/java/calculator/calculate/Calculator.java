package com.programmers.java.calculator.calculate;

import java.util.List;

public class Calculator {
    public double calculate(List<String> tokenList) {
        double prevOperand = 0.0;
        double nextOperand = 0.0;
        Operator operator = Operator.NONE;

        for (String token : tokenList) {
            if (isOperand(token) && operator==Operator.NONE) {
                prevOperand = Double.parseDouble(token);
                continue;
            }
            if (isOperand(token) && operator!=Operator.NONE) {
                nextOperand = Double.parseDouble(token);
                prevOperand = operator.calculate(prevOperand, nextOperand);
                continue;
            }
            operator = Operator.findByOperator(token);
        }
        return prevOperand;
    }

    public boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}