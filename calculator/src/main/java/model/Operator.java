package model;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

@Getter
public enum Operator {
    PLUS("+", 1, (a, b) -> (a + b)),
    MINUS("-", 1, (a, b) -> (a - b)),
    MULTIPLY("*", 2, (a, b) -> (a * b)),
    DIVIDE("/", 2, (a, b) -> {
        if (b == 0) throw new ArithmeticException();
        return a / b;
    });
    private final String operation;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String operation, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.operation = operation;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public static Operator parse(String operation) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.operation.equals(operation))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a, b);
    }


}