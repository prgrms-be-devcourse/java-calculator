package com.programmers.enumtype;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> binaryOperation;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.binaryOperation = function;
    }

    public static Operator getValue(String operator) {
        return Arrays.stream(values())
                .filter(it -> Objects.equals(it.operator, operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자를 입력해주세요. 입력: " + operator));
    }

    @Override
    public String toString() {
        return operator;
    }

    public static int binaryOperate(int num1, int num2, String operator) {
        return getValue(operator)
                .binaryOperation.apply(num1, num2);
    }
}
