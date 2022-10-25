package com.programmers.domain;

import java.util.function.BinaryOperator;

public enum CalculatorType {
    PLUS((num1, num2) -> num1 + num2),
    MINUS((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> {
        isDividedByZero(num2);
        return num1 / num2;
    });

    public static final int ZERO_NUMBER = 0;
    private BinaryOperator<Integer> expression;

    CalculatorType(BinaryOperator<Integer> expression) {
        this.expression = expression;
    }

    public Integer calculate(int num1, int num2) {
        return this.expression.apply(num1, num2);
    }

    public static CalculatorType selectType(char sign) {
        switch (sign) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return MULTIPLY;
            case '/':
                return DIVIDE;
        }
        throw new IllegalArgumentException("제대로된 사칙연산기호를 입력해 주세요. 입력 값: " + sign);
    }

    private static void isDividedByZero(int numberTwo) {
        if (numberTwo == ZERO_NUMBER) {
            throw new ArithmeticException("0으로 나눌수 없습니다.");
        }
    }

}
