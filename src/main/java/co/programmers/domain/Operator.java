package co.programmers.domain;

import co.programmers.exception.ExceptionMessage;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    ADDITION("+", 2, (operand1, operand2) -> Integer.valueOf(
            operand1 + operand2
    )),
    SUBTRACTION("-", 2, (operand1, operand2) -> Integer.valueOf(
            operand2 - operand1
    )),
    MULTIPLICATION("*", 1, (operand1, operand2) -> Integer.valueOf(
            operand1 * operand2
    )),
    DIVISION("/", 1, (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDED_BY_ZERO);
        }
        return Integer.valueOf(operand1 / operand2);
    }),
    OPENED_PARENTHESIS("(", 3, (operand1, operand2) -> 0),
    CLOSED_PARENTHESIS(")", 3, (operand1, operand2) -> 0);

    private static final Map<String, Operator> operators =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Operator::getSymbol, Function.identity())));
    private final String symbol;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, int priority, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
    }

    public static Integer calculate(String operator, Integer operand1, Integer operand2) {
        return getSymbol(operator).operation.apply(operand1, operand2);
    }

    public static Operator getSymbol(String operator) {
        return Optional.ofNullable(operators.get(operator))
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_SYMBOL));
    }

    private String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }
}