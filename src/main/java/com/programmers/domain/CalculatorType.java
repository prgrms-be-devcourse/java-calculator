package com.programmers.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum CalculatorType {
    PLUS('+', (num1, num2) -> num1 + num2),
    MINUS('-', (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> {
        isDividedByZero(num2);
        return num1 / num2;
    });

    private static final int ZERO_NUMBER = 0;
    private final char type;
    private final BinaryOperator<Integer> expression;

    CalculatorType(char type, BinaryOperator<Integer> expression) {
        this.type = type;
        this.expression = expression;
    }

    public Integer calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }

    public static CalculatorType selectType(char sign) {
        return Arrays.asList(CalculatorType.values())
                .stream()
                .filter(calculatorType -> calculatorType.type == sign)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("제대로된 사칙연산기호를 입력해 주세요. 입력 값: " + sign));
    }

    public static boolean containType(char inputType) {
        return Arrays.asList(CalculatorType.values())
                .stream()
                .map(calculatorType -> calculatorType.type)
                .anyMatch(type -> type == inputType);
    }


    private static void isDividedByZero(int numberTwo) {
        if (numberTwo == ZERO_NUMBER) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
    }

}
