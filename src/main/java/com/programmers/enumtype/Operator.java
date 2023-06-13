package com.programmers.enumtype;

import com.programmers.util.Arithmetic;

import java.util.Arrays;
import java.util.Objects;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
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
}
