package org.example.util;

import org.example.exception.BadEquationException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, Double::sum),
    Minus("-", 1, (a, b) -> a - b),
    MULTIPLY("*", 2, (a, b) -> a * b),
    DIVIDE("/", 2, (a, b) -> a / b);

    private final String operater;
    private final int priority;
    private BiFunction<Double, Double, Double> calculateFunction;

    Operator(String operater, int priority, BiFunction<Double, Double, Double> calculateFunction) {
        this.operater = operater;
        this.priority = priority;
        this.calculateFunction = calculateFunction;
    }

    public static Operator getOperator(String str){
        return Arrays.stream(Operator.values())
                .filter((a) -> a.operater.equals(str))
                .findFirst()
                .orElseThrow(BadEquationException::new);
    }

    public static boolean isOperator(String str){
        return Arrays.stream(Operator.values())
                .anyMatch((a) -> a.operater.equals(str));
    }

    public int getPriority(){
        return priority;
    }

    public double calculateByOperator(double num1, double num2){
        return calculateFunction.apply(num1, num2);
    }



}
