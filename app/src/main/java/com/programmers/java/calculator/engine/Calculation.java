package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.*;

public class Calculation {
    public Arithmetic toPostfix(Arithmetic arithmetic) {
        String[] infix = arithmetic.getArithmetic().toArray(String[]::new);
        String[] postfix = new String[infix.length];
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < infix.length; i++) {
            if (i % 2 == 0) {
                postfix[index++] = (infix[i]);
            } else {
                if (!arrayDeque.isEmpty()) {
                    if (!(RegularExpression.isSum(arrayDeque.peek()) && RegularExpression.isMulti(infix[i]))) {
                        while (!arrayDeque.isEmpty()) {
                            postfix[index++] = arrayDeque.pop();
                        }
                    }
                }
                arrayDeque.push(infix[i]);
            }
        }

        while (!arrayDeque.isEmpty()) {
            postfix[index++] = arrayDeque.pop();
        }
        return new Arithmetic(new ArrayList<>(Arrays.asList(postfix)));
    }

    public double doCalculation(Arithmetic postfix) {
        String[] arithmetic = postfix.getArithmetic().toArray(String[]::new);
        Deque<Double> deque = new ArrayDeque<>();

        for (String operandOrOperator : arithmetic) {
            if (RegularExpression.isNumeric(operandOrOperator)) {
                deque.push(Double.parseDouble(operandOrOperator));
            } else {
                double b = deque.pop();
                double a = deque.pop();
                double result = calc(a, b, operandOrOperator);
                deque.push(result);
            }
        }
        return deque.pop();
    }

    public double calc(double operandA, double operandB, String Operator) {
        double result;
        switch (Operator) {
            case "+" -> result = operandA + operandB;
            case "-" -> result = operandA - operandB;
            case "*" -> result = operandA * operandB;
            case "/" -> result = operandA / operandB;

            default -> throw new IllegalStateException("Unexpected value: " + Operator);
        }
        return result;
    }
}