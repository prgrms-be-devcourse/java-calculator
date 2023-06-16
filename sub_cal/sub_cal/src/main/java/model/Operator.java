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

    public static Optional<Operator> getOperator(String inputOperator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(inputOperator))
                .findFirst();
    }

     Operator(String operator) {
        this.operator = operator;
    }
}
