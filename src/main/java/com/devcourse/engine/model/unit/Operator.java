package com.devcourse.engine.model.unit;

import com.devcourse.engine.model.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static com.devcourse.engine.model.exception.InvalidInputException.ZERO_DIVIDE;

public enum Operator {
    PLUS("+", 1, Double::sum),
    MINUS("-", 1, (b, a) -> a - b),
    MULTIPLY("*", 2, (b, a) -> a * b),
    DIVIDE("/", 2, (b, a) -> {
        if (b == 0)
            throw new InvalidInputException(ZERO_DIVIDE);
        return a / b;
    }),
    OPEN_BRANKET("(", 0, (b, a) -> 0.0),
    CLOSE_BRANKET(")", 0, (b, a) -> 0.0);

    private final String operatorString;
    private final int operatorPriority;
    private final BiFunction<Double, Double, Double> operatorFunction;

    Operator(String str, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.operatorString = str;
        this.operatorPriority = priority;
        this.operatorFunction = biFunction;
    }

    public static boolean isOperator(String token) {
        return Arrays.stream(Operator.values())
                .anyMatch(o -> o.getOperatorString().equals(token));
    }

    public static Operator getOperator(String expression) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getOperatorString().equals(expression))
                .findAny()
                .orElseThrow(() -> new InvalidInputException(InvalidInputException.INVALID_EXPRESSION));
    }

    public Double calculate(Double num1, Double num2) {
        return operatorFunction.apply(num1, num2);
    }

    public int getOperatorPriority() {
        return operatorPriority;
    }

    public String getOperatorString() {
        return operatorString;
    }
}
