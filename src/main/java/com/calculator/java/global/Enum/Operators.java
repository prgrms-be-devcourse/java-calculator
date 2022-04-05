package com.calculator.java.global.Enum;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operators {
    PLUS("+"), MINUS("-"), MULTIPLICATION("*"), DIVISION("/");

    private final String operator;
    private static final Map<String, Operators> operators =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Operators::getOperator, Function.identity())));

    Operators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static boolean containsOperator(String operator) {
        return operators.containsKey(operator);
    }

    public static Operators findOperator(String operator) {
        return operators.get(operator);
    }
}
