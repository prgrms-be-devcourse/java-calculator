package src.exception;


public enum ErrorMessage {
    INVALID_EXPRESSION("잘못된 수식입니다."),
    NOT_FOUND_OPERATOR("연산자가 부족합니다."),
    EMPTY_EXPRESSION("수식이 비어있습니다."),
    NOT_FOUND_OPERAND("피연산자가 부족합니다."),
    DIVIDE_BY_ZERO("0으로 나눌 수 없습니다."),
    INVALID_CHOICE("잘못된 입력입니다.");

    private final String message;


    public String getMessage() {
        return message;
    }

    ErrorMessage(String message) {
        this.message = message;
    }
}
