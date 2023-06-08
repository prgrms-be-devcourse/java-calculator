package com.devcourse.java.common;

public enum Errors {
    NOT_A_NUMBER("숫자가 아닙니다."),
    DIVIDE_BY_ZERO("0으로 나눌 수 없습니다.")
    ;

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
