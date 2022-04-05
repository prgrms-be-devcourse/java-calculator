package com.caculator.util;

import java.util.Arrays;
import java.util.function.ToLongBiFunction;

public enum Operator {
    ADD("+",(n1, n2) -> n1 + n2),
    SUBTRACT("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private final String operator;
    private final ToLongBiFunction<Long, Long> function;

    Operator(String operator, ToLongBiFunction<Long, Long> function) {
        this.operator = operator;
        this.function = function;
    }

    /**
     * num1, num2 를 대상으로 operator 연산을 하여 결과를 반환한다.
     * @throws IllegalArgumentException : getOperator() 에서 operator 가 연산자가 아닌 경우 던져진다.
     * @throws ArithmeticException : 나누기 연산에서 0으로 나누는 연산이 실행되는 경우 던져진다.
     */
    public static long calculate(String operator, long num1, long num2) throws IllegalArgumentException, ArithmeticException {
        return getOperator(operator).function.applyAsLong(num1, num2);
    }

    /**
     * s 와 일치하는 연산자 enum 값을 반환한다.
     */
    private static Operator getOperator(String s)  throws IllegalArgumentException {
        return Arrays.stream(Operator.values()).filter(operator -> operator.operator.equals(s))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("s는 연산자가 아닙니다."));
    }

    /**
     * s 가 연산자(+, -, *, /)이면 true 를 반환한다.
     */
    public static boolean isOperator(String s) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.operator.equals(s));
    }
}
