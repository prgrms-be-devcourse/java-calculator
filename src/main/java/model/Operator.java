package model;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public enum Operator {
    PLUS("+", 0),
    MINUS("-", 0),
    MULTIPLY("*", 1),
    DIVIDE("/", 1);

    private final String operator;
    private final int precedence;
    private final Deque<Operator> stack;

    Operator(String operator, int precedence) {
        this.operator = operator;
        this.precedence = precedence;
        this.stack = new ArrayDeque<>();
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow();
    }

    public int getPrecedence() {
        return precedence;
    }
}
