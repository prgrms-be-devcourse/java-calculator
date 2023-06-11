package exception;

public enum ExceptionMessage {
    INPUT_BUTTON_NOT_RANGE("1 또는 2만 입력 가능합니다."),
    INVALID_NOT_EXPRESSION("수식이 틀렸습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
