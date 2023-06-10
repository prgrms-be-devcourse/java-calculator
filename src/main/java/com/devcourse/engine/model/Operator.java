package com.devcourse.engine.model;

import com.devcourse.engine.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Operator {
    PLUS("+", 1, (a, b) -> a + b),
    MINUS("-", 1, (a, b) -> a - b),
    MULTIPLY("*", 2, (a, b) -> a * b),
    DIVIDE("/", 2, (a, b) -> {
        if (b == 0)
            throw new InvalidInputException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private String operatorString;
    private int operatorPriority;
    private BiFunction<Integer, Integer, Integer> operatorFunction;

    public static boolean isOperator(String token) {
        return Arrays.stream(Operator.values())
                .anyMatch((o) -> o.getOperatorString().equals(token));
    }

    public static Operator getOperator(String exp) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getOperatorString().equals(exp))
                .toList().get(0);
    }
}
