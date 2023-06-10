package com.devcourse.engine.model;

import com.devcourse.engine.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;

@AllArgsConstructor
@Getter
public enum Operator {
    PLUS("+", 1, (b, a) -> a + b),
    MINUS("-", 1, (b, a) -> a - b),
    MULTIPLY("*", 2, (b, a) -> a * b),
    DIVIDE("/", 2, (b, a) -> {
        if (b == 0)
            throw new InvalidInputException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private String operatorString;
    private int operatorPriority;
    private BiFunction<Double, Double, Double> operatorFunction;

    public static boolean isOperator(String token) {
        return Arrays.stream(Operator.values())
                .anyMatch((o) -> o.getOperatorString().equals(token));
    }

    public static Operator getOperator(String exp) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getOperatorString().equals(exp))
                .toList().get(0);
    }

    public Double calculate(Double num1, Double num2) {
        return operatorFunction.apply(num1, num2);
    }
}
