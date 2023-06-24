package model;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    NULL("."),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;

    public static Operator getOperator(String inputOperator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(inputOperator))
                .findFirst().orElse(Operator.NULL);
    }

     Operator(String operator) {
        this.operator = operator;
    }

    public static boolean isPlus(String operator) {
        return operator.equals("PLUS");
    }

    public static boolean isMultiply(String operator) {
        return operator.equals("MULTIPLY");
    }
}