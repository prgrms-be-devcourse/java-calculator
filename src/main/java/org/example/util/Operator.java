package org.example.util;

import org.example.validate.Validater;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2),
    OPEN_BRACKET("(", null),
    CLOSE_BRACKET(")", null);

    private final String operator;
    private BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static boolean isOperatorOrBracket(String input) {
        return Validater.isOperatorOrBracket(input);
    }

    public static boolean isOperator(String input) {
        return Validater.isOperator(input);
    }

    public static Operator getOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getOperator() {
        return operator;
    }

    public Integer doCalculate(int num1, int num2) {
        return biFunction.apply(num1, num2);
    }

    public int getPriority() {
        if (operator.equals("(") || operator.equals(")")) {
            return 0;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else {
            return 2;
        }
    }
}
