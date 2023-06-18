package com.programmers.engine.model.operation;

import com.programmers.engine.exception.CalculatorErrorCode;
import com.programmers.engine.exception.CalculatorException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator getOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(o -> Objects.equals(o.operator, input))
                .findAny()
                .orElseThrow(() -> new CalculatorException(CalculatorErrorCode.OPERATOR_ERROR));
    }

    public Integer calculate(Integer operand1, Integer operand2) {
        return biFunction.apply(operand1, operand2);
    }
}
