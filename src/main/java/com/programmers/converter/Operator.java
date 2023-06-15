package com.programmers.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+", 2, BigDecimal::add),
    SUBTRACT("-", 2, BigDecimal::subtract),
    MULTIPLY("*", 1, BigDecimal::multiply),
    DIVIDE("/", 1, (n1, n2) -> {
        if (n2.doubleValue() == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return n1.divide(n2, 30, RoundingMode.HALF_EVEN);
    }),
    OPEN_PARENTHESES("(", 3, (n1, n2) -> BigDecimal.valueOf(0));

    private static final Map<String, Operator> OPERATOR_MAP =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(Operator::getSymbol, Function.identity())));

    private final String symbol;
    private final int priority;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> function;


    Operator(String symbol, int priority, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        this.symbol = symbol;
        this.priority = priority;
        this.function = function;
    }

    public static boolean isOperator(String symbol) {
        return OPERATOR_MAP.containsKey(symbol);
    }

    public static Operator getOperation(String symbol) {
        if (OPERATOR_MAP.containsKey(symbol))
            return OPERATOR_MAP.get(symbol);

        throw new IllegalArgumentException("잘못된 연산자가 들어왔습니다." + symbol);
    }

    public boolean isComparePriority(Operator operator) {
        return this.priority - operator.getPriority() <= 0;
    }

    public boolean isOpenParentheses() {
        return this == OPEN_PARENTHESES;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getPriority() {
        return this.priority;
    }

    public BigDecimal operation(BigDecimal n1, BigDecimal n2) {
        return function.apply(n1, n2);
    }


}
