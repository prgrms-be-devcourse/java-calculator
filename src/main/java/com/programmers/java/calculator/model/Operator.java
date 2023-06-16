package com.programmers.java.calculator.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {

    ADDITION("+", 2, BigDecimal::add),
    SUBTRACTION("-", 2, BigDecimal::subtract),
    MULTIPLICATION("*", 1, BigDecimal::multiply),
    DIVISION("/", 1, BigDecimal::divide);

    private final String symbol;
    private final int priority;
    private final BinaryOperator<BigDecimal> function;

    Operator(String symbol, int priority, BinaryOperator<BigDecimal> function) {
        this.symbol = symbol;
        this.priority = priority;
        this.function = function;
    }

    private static final Map<String, Operator> OPERATOR_MAP;

    static {
        Map<String, Operator> map = new HashMap<>();
        for (Operator operator : values()) {
            map.put(operator.getSymbol(), operator);
        }
        OPERATOR_MAP = Collections.unmodifiableMap(map);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public int comparePriority(Operator newOperator) {
        return Integer.compare(this.getPriority(), newOperator.getPriority());
    }

    public BigDecimal calculate(BigDecimal a, BigDecimal b) {
        return this.function.apply(a, b);
    }

    public static Operator of(String symbol) {
        if (OPERATOR_MAP.containsKey(symbol)) {
            return OPERATOR_MAP.get(symbol);
        }

        throw new IllegalArgumentException("잘못 입력되었습니다");
    }
}
