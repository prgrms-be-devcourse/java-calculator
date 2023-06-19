package com.programmers.util;

import com.programmers.exception.DivideByZeroException;

import javax.management.StringValueExp;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (num1, num2)-> num1 + num2),
    MINUS("-", 1, (num1, num2)-> num1 - num2),
    MULTIPLY("*", 2, (num1, num2)-> num1 * num2),
    DIVIDE("/", 2, (num1, num2)-> {
        if (num2 == 0) {
            throw new DivideByZeroException();
        }
        return num1 / num2;
    }),
    OPEN_BRACKET("(", 0, null),
    CLOSE_BRACKET(")", 0, null);

    private final String operator;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public static boolean contains(String cur) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.getOperator().equals(cur));
    }

    public static double operate(String cur, double num1, double num2) {
        for (Operator operator : Operator.values()) {
            if (cur.equals(operator.getOperator())) {
                return operator.biFunction.apply(num1, num2);
            }
        }
        return 0;
    }

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

    public static int getPriority(char targetOperator) {
        String target = String.valueOf(targetOperator);
        for (Operator operator : Operator.values()) {
            if (operator.getOperator().equals(target)) {
                return operator.getPriority();
            }
        }
        return 0;
    }

}
