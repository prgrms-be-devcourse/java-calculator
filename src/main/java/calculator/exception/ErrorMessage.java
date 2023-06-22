package calculator.exception;

public enum ErrorMessage {
    NOT_FOUND_OPTION("[ERROR] 해당 명령이 존재하지 않습니다."),
    WRONG_EXPRESSION_EXCEPTION("[ERROR] 잘못된 사칙연산 순서입니다."),
    ZERO_DIVISION_OPTION("[ERROR] 0으로는 나눌 수 없습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
