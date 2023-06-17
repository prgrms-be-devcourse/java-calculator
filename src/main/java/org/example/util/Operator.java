package org.example.util;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    OPEN_BRACKET("("),
    CLOSE_BRACKET(")");

    private static final Pattern OPERATOR = Pattern.compile("[+-/*()]");

    private String operator;
    Operator(String operator) {
        this.operator = operator;
    }

    public static boolean isOperator(String input) {
        return OPERATOR.matcher(input).matches();
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
