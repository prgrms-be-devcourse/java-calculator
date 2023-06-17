package org.example.validate;

import java.util.regex.Pattern;

public class InputValidater {
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 숫자 1, 2 또는 3을 입력해주세요.";
    private static final Pattern PROPER_COMMAND_REGEX = Pattern.compile("[123]");


    public void validateCommand(final String command) {

        if(!PROPER_COMMAND_REGEX.matcher(command).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_COMMAND);
        }
    }
}
