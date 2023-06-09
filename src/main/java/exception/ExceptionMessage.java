package exception;

public enum ExceptionMessage {
    INPUT_BUTTON_NOT_RANGE("1 또는 2만 입력 가능합니다."),
    INVALID_NOT_FORMULA("수식이 틀렸습니다.");

    public static final String BASE_MESSAGE = "[ERROR] : %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
