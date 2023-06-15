package org.example.validate;

public class InputValidater {
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 숫자 1또는 2를 입력해주세요.";

    public void validateExpression(String expression) {//추후 검증 로직 추가
    }

    public void validateCommand(final String command) {
        final String REGEX = "[12]";
        if(!command.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_COMMAND);
        }
    }
}
