package io;

public enum DisplayMessage {
    SELECT("1. 조회"),
    CALCULATION("2. 계산"),
    EXIT("3. 종료"),
    CHOOSE("선택 : "),
    OUTPUT("계산 결과 : "),
    BAD_REQUEST("잘못된 명령입니다!"),
    WRONG_EXPR("잘못된 계산식입니다!"),
    SPLIT_LINE("==================");

    private final String message;

    DisplayMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
