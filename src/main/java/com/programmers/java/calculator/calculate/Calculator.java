package com.programmers.java.calculator.calculate;

import com.programmers.java.record.CalculationRecord;

import java.util.List;

public class Calculator {

    private static CalculationRecord resultRepository = new CalculationRecord();

    public double calculate(List<String> tokenList) {
        double tempResult = 0.0;
        String operator = "";

        for (String token : tokenList) {
            if (isOperand(token) && operator.equals("")) {
                tempResult = Double.parseDouble(token);
                continue;
            }
            if (isOperand(token) && !operator.equals("")) {
                tempResult = calculate(Double.parseDouble(token), tempResult, operator);
                continue;
            }
            operator = token;
        }
        return tempResult;
    }

    public boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public double calculate(double prevOperand, double nextOperand, String token) {
        Operator operator = Operator.findByOperator(token);
        return operator.calculate(prevOperand, nextOperand);
    }
}