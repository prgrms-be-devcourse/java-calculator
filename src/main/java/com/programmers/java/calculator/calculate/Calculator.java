package com.programmers.java.calculator.calculate;

import com.programmers.java.repository.ResultRepository;

import java.util.List;

public class Calculator {

    private static ResultRepository resultRepository = new ResultRepository();

    public double calculate(List<String> tokenList) {
        double tempResult = 0.0;
        String operator = "";

        for (String token : tokenList) {
            if (isDigit(token) && operator.equals("")) {
                tempResult = Double.parseDouble(token);
                continue;
            }

            if (isDigit(token) && !operator.equals("")) {
                tempResult = calculate(token, tempResult, operator);
                continue;
            }
            operator = token;
        }
        return tempResult;
    }

    public boolean isDigit(String strValue) {
        try {
            Long.parseLong(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public double calculate(String token, double prevOperand, String operator) {
        double result = 0.0;
        switch (operator) {
            case "+": {
                double nextOperand = Double.parseDouble(token);
                result = prevOperand + nextOperand;
                break;
            }
            case "-": {
                double nextOperand = Double.parseDouble(token);
                result = prevOperand - nextOperand;
                break;
            }
            case "/": {
                double nextOperand = Double.parseDouble(token);
                result = prevOperand / nextOperand;
                break;
            }
            case "*": {
                double nextOperand = Double.parseDouble(token);
                result = prevOperand * nextOperand;
                break;
            }
        }
        return result;
    }
}