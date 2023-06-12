package calculator.exception;

public enum ErrorMessage {
    NOT_FOUND_OPTION("[ERROR] 해당 명령이 존재하지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
