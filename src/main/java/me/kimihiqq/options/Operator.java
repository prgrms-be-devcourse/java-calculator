package me.kimihiqq.options;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b),
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b);

    private final String operatorString;
    private final BiFunction<Double, Double, Double> calculation;

    Operator(String operatorString, BiFunction<Double, Double, Double> calculation) {
        this.operatorString = operatorString;
        this.calculation = calculation;
    }

    public static Optional<Operator> from(String operatorString) {
        return Arrays.stream(values())
                .filter(operator -> operator.operatorString.equals(operatorString))
                .findFirst();
    }

    public double calculate(double leftHandSide, double rightHandSide) {
        return calculation.apply(leftHandSide, rightHandSide);
    }
}