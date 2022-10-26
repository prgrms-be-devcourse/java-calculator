package com.programmers.java.application;

import com.programmers.java.engine.model.Answer;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (lhs, rhs) -> lhs + rhs),
    MINUS("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE("/", (lhs, rhs) -> lhs / rhs);

    private String operator;
    private BiFunction<Double, Double, Double> expression;
    private static Map<String, Operator> operatorMap = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(Operator::getOperator, Function.identity()))
    );

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public static Answer calculate(String operator, Double lhs, Double rhs) {
        return Answer.builder()
                .value(
                        findOperator(operator).expression.apply(lhs, rhs)
                )
                .build();
    }

    public static Operator findOperator(String operator) {
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow();
    }
}
