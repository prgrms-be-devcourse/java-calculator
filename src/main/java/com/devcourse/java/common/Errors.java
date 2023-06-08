package com.devcourse.java.common;

public enum Errors {
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
