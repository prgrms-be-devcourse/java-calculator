package com.programmers.java.calculator.arithmetic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Operator {
    private final Validator validator = new Validator();

    public String getResult(List<String> postfix) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < postfix.size(); i++) {
            stack.addLast(postfix.get(i));
            if (validator.isOperator(postfix.get(i))){
                stack.removeLast();

                Double n2 = Double.parseDouble(stack.getLast()); // 역순으로 뽑아냄
                stack.removeLast();

                Double n1 = Double.parseDouble(stack.getLast());
                stack.removeLast();

                String calculationResult = switch (postfix.get(i)){
                    case "+" -> Double.toString(n1 + n2);
                    case "-" -> Double.toString(n1 - n2);
                    case "*" -> Double.toString(n1 * n2);
                    case "/" -> Double.toString(n1 / n2);
                    default -> "";
                };
                stack.addLast(calculationResult);
            }
        }

        String res = stack.getFirst();
        if (validator.isDecimal(res)) // 실수
            return roundSecondDecimal(Double.parseDouble(res));

        if (res.contains("."))
            return res.substring(0, res.indexOf(".")); // 정수인데 . 포함된 경우

        return res; // 그냥 정수
    }

    private String roundSecondDecimal(Double number){
        return String.format("%.2f", number);
    }
}
