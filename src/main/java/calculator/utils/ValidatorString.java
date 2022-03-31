package calculator.utils;

import java.util.regex.Pattern;

public class ValidatorString {
    private static final Pattern NUMBER = Pattern.compile("-?\\d+(.\\d+)?");
    private static final Pattern OPERATOR = Pattern.compile("[+-/*]");

    private ValidatorString() {
    }

    public static boolean isNumber(String value) {
        return NUMBER.matcher(value)
            .matches();
    }

    public static boolean isOperator(String value) {
        return OPERATOR.matcher(value)
            .matches();
    }
}
