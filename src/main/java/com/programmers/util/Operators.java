package com.programmers.util;

import com.programmers.error.exception.InvalidOperatorInputException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operators {

    PLUS("+", (num1, num2) -> num1 + num2),
    SUBTRACTION("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVISION("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Long, Long, Long> function;

    Operators(String operator, BiFunction<Long, Long, Long> function) {
        this.symbol = operator;
        this.function = function;
    }

    public static Operators getOperator(String inputOperator) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(inputOperator))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorInputException("잘못된 수식입니다. +, -, *, / 연산만 가능합니다."));
    }


    public static long calculate(String operator, long num1, long num2) {
        return getOperator(operator).function.apply(num1, num2);
    }

    public static boolean isOperator(String unCheckedOperator) {
        return Arrays.stream(Operators.values())
                .anyMatch(operators -> operators.symbol.equals(unCheckedOperator));
    }
}
