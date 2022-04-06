package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.*;

public class Calculation {
    public Arithmetic toPostfix(Arithmetic arithmetic) {
        List<String> infix = arithmetic.getArithmetic();
        List<String> postfix = new ArrayList<>();
        Deque<String> arrayDeque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < infix.size(); i++) {
            if (i % 2 == 0) {
                postfix.add(infix.get(i));
            } else {
                if (!arrayDeque.isEmpty()) {
                    if (!(RegularExpression.isSum(arrayDeque.peek()) && RegularExpression.isMulti(infix.get(i)))) {
                        while (!arrayDeque.isEmpty()) {
                            postfix.set(index++, arrayDeque.pop());
                        }
                    }
                }
                arrayDeque.push(infix.get(i));
            }
        }

        while (!arrayDeque.isEmpty()) {
            postfix.set(index++, arrayDeque.pop());
        }
        return new Arithmetic(postfix);
    }

    public double doCalculation(Arithmetic postfix) {
        List<String> arithmetic = postfix.getArithmetic();
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