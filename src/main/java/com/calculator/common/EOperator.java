package com.calculator.common;

import java.util.function.BiFunction;

public enum EOperator {

    ADD('+', 2, Double::sum),
    SUB('-', 2, (a, b) -> a - b),
    MUL('*', 1, (a, b) -> a * b),
    DIV('/', 1, (a, b) -> a / b),
    LEFT('(',3, null),
    RIGHT(')', 3, null),;

    private final char name;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;

    EOperator(char name, int priority, BiFunction<Double, Double, Double> biFunction) {
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
        return this.biFunction.apply(a, b);
    }

    public int compare(EOperator e) {
        if (this.getPriority() < e.getPriority()) {
            return -1;
        } else if (this.getPriority() == e.getPriority()) {
            return 0;
        }

        return 1;
    }
}
