package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Arithmetic;
import com.programmers.java.calculator.engine.utils.RegularExpression;

import java.util.ArrayDeque;
import java.util.Optional;

public class Calculation {
    public Arithmetic toPostfix(Arithmetic arithmetic) {
        String[] infix = arithmetic.getArithmetic();
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
        return new Arithmetic(postfix);
    }

    public Optional<Double> doCalculation(Arithmetic postfix) {
        String[] arithmetic = postfix.getArithmetic();
        ArrayDeque<Double> deque = new ArrayDeque<>();

        for (String s : arithmetic) {
            if (RegularExpression.isNumeric(s)) {
                deque.push(Double.parseDouble(s));
            } else {
                Double b = deque.pop();
                Double a = deque.pop();
                Optional<Double> result = calc(a, b, s);
                if (result.isEmpty()) {
                    return Optional.empty();
                } else {
                    deque.push(result.get());
                }
            }
        }
        return Optional.ofNullable(deque.poll());
    }

    public Optional<Double> calc(Double operandA, Double operandB, String Operator) {
        Optional<Double> result;
        switch (Operator) {
            case "+" -> result = Optional.of(operandA + operandB);
            case "-" -> result = Optional.of(operandA - operandB);
            case "*" -> result = Optional.of(operandA * operandB);
            case "/" -> result = Optional.of(operandA / operandB);

            default -> throw new IllegalStateException("Unexpected value: " + Operator);
        }
        return result;
    }
}