package com.programmers.java.calculator.arithmetic;

import java.util.ArrayList;
import java.util.Stack;

public class Operator {
    private final Validator validator = new Validator();

    public String getResult(ArrayList<String> postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.size(); i++) {
            stack.push(postfix.get(i));
            if (validator.isOperator(postfix.get(i))){
                stack.pop();
                Double n2 = Double.parseDouble(stack.pop()); // 역순으로 뽑아냄
                Double n1 = Double.parseDouble(stack.pop());

                String calculationResult = switch (postfix.get(i)){
                    case "+" -> Double.toString(n1 + n2);
                    case "-" -> Double.toString(n1 - n2);
                    case "*" -> Double.toString(n1 * n2);
                    case "/" -> Double.toString(n1 / n2);
                    default -> "";
                };
                stack.push(calculationResult);
            }
        }

        String res = stack.get(0);
        if (validator.isDecimal(res)) // 실수
            return res;

        if (res.contains("."))
            return res.substring(0, res.indexOf(".")); // 정수인데 . 포함된 경우

        return res; // 그냥 정수
    }
}
