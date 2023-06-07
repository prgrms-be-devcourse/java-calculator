package com.devcourse.java.common;

public enum Errors {
    NOT_A_NUMBER("숫자가 아닙니다.")
    ;

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
