package com.programmers.calculator.core;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", Double::sum),
    SUBTRACT("-", (leftValue, rightValue) -> leftValue - rightValue),
    MULTIPLY("*", (leftValue, rightValue) -> leftValue * rightValue),
    DIVIDE("/", (leftValue, rightValue) -> {
        if (rightValue == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return leftValue / rightValue;}
    );

    private final String operator;

    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Double calculate(String operatorStr, double leftValue, double rightValue) {
        return findOperator(operatorStr).expression.apply(leftValue, rightValue);
    }

    public static Operator findOperator(String operatorStr) {
        return Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operatorStr))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다"));
    }

    public static boolean isOperator(String operatorStr) {
        Optional<Operator> findOperator = Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operatorStr))
                .findAny();

        return findOperator.isPresent();
    }

    public static boolean isHigherPriorityOperator(String value) {
        Optional<Operator> optionalOperator = Arrays.stream(values())
                .filter(operator -> operator.operator.equals(value))
                .findAny();

        if (optionalOperator.isEmpty()) {
            return false;
        }

        switch (optionalOperator.get()) {
            case MULTIPLY:
            case DIVIDE:
                return true;
            default: return false;
        }

    }

}