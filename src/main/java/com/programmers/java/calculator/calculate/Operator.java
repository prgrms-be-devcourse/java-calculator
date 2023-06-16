package com.programmers.java.calculator.calculate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    NONE("", 0, (preOperand, nextOperand) -> null),
    PLUS("+", 1, (preOperand, nextOperand) -> preOperand + nextOperand),
    MINUS("-", 1, (preOperand, nextOperand) -> preOperand - nextOperand),
    MULTIPLE("*", 2, (preOperand, nextOperand) -> preOperand * nextOperand),
    DIVIDE("/", 2, (preOperand, nextOperand) -> preOperand / nextOperand);

    private String operator;
    private int priority;
    private BiFunction<Double, Double, Double> calculateLamda;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> calculateLamda) {
        this.operator = operator;
        this.priority = priority;
        this.calculateLamda = calculateLamda;
    }

    public double calculate(double preOperand, double nextOperand) {
        return calculateLamda.apply(preOperand, nextOperand);
    }

    public static Operator findByOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(opt -> opt.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다."));
    }

    public boolean isBiggerPriority(Operator nextOperator) {
        int difference = this.priority - nextOperator.priority;
        if (difference > 0) {
            return true;
        }
        return false;
    }
}