package com.caculator;

import java.util.Arrays;
import java.util.function.ToLongBiFunction;

public enum Operator {
    ADD("+", (n1, n2) -> n1 + n2),
    SUBTRACT("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private final String operator;
    private final ToLongBiFunction<Long, Long> function;

    Operator(String operator, ToLongBiFunction<Long, Long> function) {
        this.operator = operator;
        this.function = function;
    }

    public static long calculate(String operator, long num1, long num2) throws IllegalArgumentException, ArithmeticException {
        return getOperator(operator).function.applyAsLong(num1, num2);
    }

    private static Operator getOperator(String s) {
        return Arrays.stream(Operator.values()).filter(operator -> operator.operator.equals(s))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isOperator(String s) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.operator.equals(s));
    }

    public static int getPriority(String operator) throws IllegalArgumentException {
        if (operator.equals("*") || operator.equals("/")) return 2;
        if (operator.equals("+") || operator.equals("-")) return 1;
        throw new IllegalArgumentException("연산자(+, -, *, /)가 아닙니다.");
    }
}
