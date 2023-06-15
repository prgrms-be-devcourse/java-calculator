package com.programmers.java.calculator.calculate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    NONE("", (preOperand, nextOperand) -> null),
    PLUS("+", (preOperand, nextOperand) -> preOperand + nextOperand),
    MINUS("-", (preOperand, nextOperand) -> preOperand - nextOperand),
    MULTIPLE("*", (preOperand, nextOperand) -> preOperand * nextOperand),
    DIVIDE("/", (preOperand, nextOperand) -> preOperand / nextOperand);

    private String operator;
    private BiFunction<Double, Double, Double> calculateLamda;

    Operator(String operator, BiFunction<Double, Double, Double> calculateLamda) {
        this.operator = operator;
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

    public static int evaluatePriority(Operator prevOperator, Operator nextOperator) {
        return prevOperator.compareTo(nextOperator);
    }
}