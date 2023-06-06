package calculator.domain.model;

import calculator.error.ResponseErrorFormat;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum SymbolPriority {

    ADD("+", 0, (a, b) -> a + b),
    SUB("-", 0, (a, b) -> a - b),
    MUL("*", 1, (a, b) -> a * b),
    DIV("/", 1, (a, b) -> a / b),
    ;

    private String symbol;

    private int priority;

    private BinaryOperator<Integer> operation;

    SymbolPriority(String symbol,
                   int priority,
                   BinaryOperator<Integer> operation) {

        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
    }

    public int getPriority() {

        return priority;
    }

    public BinaryOperator<Integer> getOperation() {
        return operation;
    }

    public static SymbolPriority from(String symbol) {

        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ResponseErrorFormat.ERROR_BAD_SYMBOL.getMessage()));
    }
}
