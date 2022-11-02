package com.calculator.common;

import java.util.function.BiFunction;

import static com.calculator.common.ExceptionStatus.DIVIDE_ZERO_ERROR;
import static com.calculator.common.ExceptionStatus.INVALID_OPERATOR;

public enum Operator {

    ADD('+', 2, Double::sum),
    SUB('-', 2, (a, b) -> a - b),
    MUL('*', 1, (a, b) -> a * b),
    DIV('/', 1, (a, b) -> a / b);

    private final char name;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;
    private static final String EXPRESSION_PATTERN = "^[+\\-*/()\\d]*$";

    Operator(char name, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.name = name;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public char getName() {
        return name;
    }

    private int getPriority() {
        return priority;
    }

    public Double calculate(double a, double b) {
        try {
            return this.biFunction.apply(a, b);
        } catch (ArithmeticException e) {
            throw new BusinessException(DIVIDE_ZERO_ERROR);
        }
    }

    public int compare(Operator e) {
        if (this.getPriority() < e.getPriority()) {
            return -1;
        } else if (this.getPriority() == e.getPriority()) {
            return 0;
        }

        return 1;
    }

    public static Operator of(char name) {
        for (Operator e : Operator.values()) {
            if (e.getName() == name) {
                return e;
            }
        }

        throw new BusinessException(INVALID_OPERATOR);
    }
}
