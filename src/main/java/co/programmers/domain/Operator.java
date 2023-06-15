package co.programmers.domain;

import co.programmers.exception.ExceptionMessage;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", 2, (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION("-", 2, (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION("*", 1, (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", 1, (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new ArithmeticException(ExceptionMessage.DIVIDED_BY_ZERO);
        }
        return operand1 / operand2;
    }),
    OPENED_PARENTHESIS("(", 3, (operand1, operand2) -> 0),
    CLOSED_PARENTHESIS(")", 3, (operand1, operand2) -> 0);

    private final String symbol;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> operation;

    private Operator(String symbol, int priority, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
    }

    public static Integer calculate(String operator, Integer operand1, Integer operand2) {
        return getSymbol(operator).operation.apply(operand1, operand2);
    }

    public static Operator getSymbol(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.symbol.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INPUT));
    }

    public static boolean isOperator(String symbol) {
        return !Arrays.stream(values())
                .filter(o -> o.symbol.equals(symbol))
                .findAny()
                .isEmpty();
    }

    public static boolean hasLowerPrecedence(String current, String toCompare) {
        Operator operator1 = getSymbol(current);
        Operator operator2 = getSymbol(toCompare);
        return (operator1.getPriority() >= operator2.getPriority());
    }

    public int getPriority() {
        return priority;
    }
}
