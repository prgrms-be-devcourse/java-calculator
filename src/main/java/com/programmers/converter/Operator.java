package com.programmers.converter;

import com.programmers.exception.WrongOperationException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 1, (n1, n2) -> n1 + n2),
    SUBTRACT( "-", 1, (n1, n2) -> n1 - n2),
    MULTIPLY( "*",2, (n1, n2) -> n1 * n2),
    DIVIDE( "/", 2, (n1, n2) -> n1 / n2),
    OPEN_PARENTHESES("(", 0, (n1, n2) -> 0L);

    private final String symbol;
    private final int priority;
    private final BiFunction<Long, Long, Long> function;

    Operator(String symbol, int priority, BiFunction<Long, Long, Long> function) {
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

    public long operation(long n1, long n2) {
        return function.apply(n1, n2);
    }


}
