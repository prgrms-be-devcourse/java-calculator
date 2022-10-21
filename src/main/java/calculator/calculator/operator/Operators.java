package calculator.calculator.operator;

import java.util.Arrays;

public enum Operators {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public static boolean isOperator(String inputOperator) {
        return Arrays.stream(Operators.values())
                .anyMatch(operator -> operator.operator.equals(inputOperator));
    }
}
