package org.example.validate;

public class InputValidater {
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 숫자 1또는 2를 입력해주세요.";
    private static final String ERROR_MESSAGE_TOO_MANY_SPACE_IN_EXPRESSION = "[ERROR] 수식에 연속 된 공백이 3칸 이상 있으면 안 됩니다.";

    public void validateExpression(String expression) {
        validateSpaceCount(expression);
        //수식 검증 메서드 쭉쭉 추가할 것.
        //...

    }

    public void validateCommand(final String command) {
        final String REGEX = "[12]";
        if(!command.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_COMMAND);
        }
    }

    private static void validateSpaceCount(String expression) {
        final String REGEX = "\\s{3,}";
        if(expression.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TOO_MANY_SPACE_IN_EXPRESSION);
        }
    }
}
