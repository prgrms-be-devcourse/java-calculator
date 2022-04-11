package com.programmers.java.engine.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

/*
 * Operator : 연산자를 관리하는 enum
 * */
public enum Operator {
    PLUS("+", (a, b) -> a + b, 0),
    MINUS("-", (a, b) -> a - b, 0),
    MULTIPLY("*", (a, b) -> a * b, 1),
    DIVIDE("/", (a, b) -> a / b, 1);

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;
    private final int priority;

    Operator(String operator, BiFunction<Double, Double, Double> expression, int priority) {
        this.operator = operator;
        this.expression = expression;
        this.priority = priority;
    }

    /* calculate : operator로 두 인자를 계산해주는 메소드 */
    public static double calculate(Operator operator, double a, double b) {
        return operator.expression.apply(a, b);
    }

    /* getOperator : 문자열로 표시된 operator에 해당하는 enum operator를 찾아주는 메소드 */
    public static Optional<Operator> getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst();
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return operator;
    }

}
