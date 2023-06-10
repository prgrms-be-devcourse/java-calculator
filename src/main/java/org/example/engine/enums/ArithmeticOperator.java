package org.example.engine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;


public enum ArithmeticOperator {
    ADDITION("+", 1, (left, right) -> left + right),
    SUBTRACTION("-", 1,  (left, right) -> left - right),
    MULTIPLICATION("*", 2,  (left, right) -> left * right),
    DIVISION("/", 2,  (Dividend, Divisor) -> {
        if (Divisor != 0) {
            return Dividend / Divisor;
        } else {
            throw new ArithmeticException("Division by zero");
        }

    });

    private String arithmeticOperator;
    private final int priority;
    private BiFunction<Double, Double, Double> expression;


    ArithmeticOperator(String arithmeticOperator, int priority, BiFunction<Double, Double, Double> expression) {
        this.arithmeticOperator = arithmeticOperator;
        this.priority = priority;
        this.expression = expression;
    }

    public String getArithmeticOperator() {
        return arithmeticOperator;
    }

    public int getPriority() {
        return priority;
    }

    public static ArithmeticOperator getArithmeticOperator(String arithmeticOperator) {
        return Arrays.stream(values())
                .filter(o -> o.arithmeticOperator.equals(arithmeticOperator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public static int comparePriority(ArithmeticOperator operator1, ArithmeticOperator operator2) {
        return Integer.compare(operator1.getPriority(), operator2.getPriority());
    }

    public static double calculate(String arithmeticOperator, double num1, double num2) {
        return getArithmeticOperator(arithmeticOperator).expression.apply(num1, num2);
    }


}
