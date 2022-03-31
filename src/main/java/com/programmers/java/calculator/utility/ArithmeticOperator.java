package com.programmers.java.calculator.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class ArithmeticOperator implements Operator {
    private final PostfixConvertor postfixConvertor;
    private Stack<Double> stack = new Stack<>();
    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");

    public ArithmeticOperator(PostfixConvertor postfixConvertor){
        this.postfixConvertor = postfixConvertor;
    }

    @Override
    public double calculate(String exp) {
        String postfix = postfixConvertor.setPostfix(exp);
        double result;
        String[] postfixSplit = postfix.split(" ");
        for (String s: postfixSplit){
            Optional<String> operator = operators.stream()
                    .filter(op -> op.equals(s))
                    .findAny();
            if (operator.isPresent()){
                double a = stack.pop();
                double b = stack.pop();
                switch(operator.get()){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }

            } else {
                stack.push(Double.valueOf(s));
            }
        }
        result = stack.pop();
        return result;
    }
}
