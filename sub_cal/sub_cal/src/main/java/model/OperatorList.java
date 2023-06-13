package model;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum OperatorList {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String operator;

    public static Optional<OperatorList> getOperator(String inputOperator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(inputOperator))
                .findFirst();
    }

     OperatorList(String operator) {
        this.operator = operator;
    }
}
