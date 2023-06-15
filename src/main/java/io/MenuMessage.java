package io;

public enum MenuMessage {
    SELECT("1. 조회"),
    CALCULATION("2. 계산"),
    EXIT("3. 종료"),
    CHOOSE("선택 : ");

    private final String message;

    MenuMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
