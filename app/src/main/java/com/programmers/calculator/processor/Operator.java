package com.programmers.calculator.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Operator {
    private final Map<String, Integer> priority = new HashMap<>() {{
        put("*", 2);
        put("/", 2);
        put("+", 1);
        put("-", 1);
    }};
    private final Map<String, BiFunction<Double, Double, Double>> calculation = new HashMap<>() {{
        put("*", (a, b) -> a * b);
        put("+", (a, b) -> a + b);
        put("-", (a, b) -> a - b);
        put("/", (a, b) ->
        {
            if ( b == 0 )
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return a / b;
        });
    }};

    public Integer getOperatorPriority(String operator) {
        return priority.get(operator);
    }

    public BiFunction<Double, Double, Double> getOperatorCalculation(String operator) {
        return calculation.get(operator);
    }
}
