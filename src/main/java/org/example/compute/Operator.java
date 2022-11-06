package org.example.compute;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", 2, (num1, num2) -> num1 + num2),
    SUBTRACT("-", 2, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 3, (num1, num2) -> num1 * num2),
    DIVIDE("/", 3, (num1, num2) -> num1 / num2);

    private final String operator;
    private final int priority;
    private final BiFunction<Long, Long, Long> expression;

    Operator(String operator, int priority, BiFunction<Long, Long, Long> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public static Operator getOperator(String newOperator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(newOperator))
                .findFirst()
                .get();
    }

    public long calculate(long num1, long num2) {
        return expression.apply(num1, num2);
    }


    public int getPriority() {
        return priority;
    }
}
