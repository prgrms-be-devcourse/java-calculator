package model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorList {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    OperatorList(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double calculate(String operator, double num1, double num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    private static OperatorList getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

}
