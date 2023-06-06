package com.programmers.converter;

import com.programmers.exception.DividedByZeroException;
import com.programmers.exception.WrongOperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 1, BigDecimal::add),
    SUBTRACT( "-", 1, BigDecimal::subtract),
    MULTIPLY( "*",2, BigDecimal::multiply),
    DIVIDE( "/", 2, (n1, n2) -> n1.divide(n2, 30, RoundingMode.HALF_EVEN)),
    OPEN_PARENTHESES("(", 0, (n1, n2) -> BigDecimal.valueOf(0));

    private final String symbol;
    private final int priority;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    Operator(String symbol, int priority, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        this.symbol = symbol;
        this.priority = priority;
        this.function = function;
    }

    public static boolean isOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.symbol.equals(symbol));
    }

    public static Operator getOperation(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new WrongOperationException("잘못된 연산자가 들어왔습니다." + symbol));
    }

    public int compareTo(int priority) {
        return this.priority - priority;
    }

    public boolean isOpenParentheses() {
        return this == OPEN_PARENTHESES;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return this.priority;
    }

    public BigDecimal operation(BigDecimal n1, BigDecimal n2) {
        if(this == DIVIDE && n2.doubleValue() == 0) {
            throw new DividedByZeroException("0으로 나눌 수 없습니다.");
        }
        return function.apply(n1, n2);
    }


}
