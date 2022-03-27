package model;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없다");
        return a / b;
    });
    private final String operation;
    private final int priority;
    private final BiFunction<Double,Double,Double> biFunction;

    Operator(String operation,BiFunction<Double,Double,Double> biFunction) {
        int prior = -1;
        this.operation = operation;
        switch(operation) {
            case "+": prior =1;
            case "-": prior =1;
            case "*": prior =2;
            case "/": prior =2;
        }
        this.priority = prior;
        this.biFunction = biFunction;
    }

    public static Operator parse(String operation) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.operation.equals(operation))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("올바른 수식을 입력해야 합니다."));
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a, b);
    }
}