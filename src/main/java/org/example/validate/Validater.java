package org.example.validate;

import java.util.regex.Pattern;

public class Validater {
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 숫자 1, 2 또는 3을 입력해주세요.";
    private static final Pattern PROPER_COMMAND_REGEX = Pattern.compile("[123]");
    private static final Pattern OPERATOR = Pattern.compile("[+-/*()]");
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");

    public static void validateCommand(final String command) {
        if(!PROPER_COMMAND_REGEX.matcher(command).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_COMMAND);
        }
    }
    public static boolean isOperator(String input) {
        return OPERATOR.matcher(input).matches();
    }
    public static boolean isNumber(String input) {
        return NUMBER.matcher(input).matches();
    }
}
