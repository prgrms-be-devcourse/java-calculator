package io;

public enum DisplayMessage {
    OUTPUT("계산 결과 : "),
    BAD_REQUEST("잘못된 명령입니다!"),
    WRONG_EXPRESSION("잘못된 계산식입니다!"),
    SPLIT_LINE("==================");

    private final String message;

    DisplayMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
