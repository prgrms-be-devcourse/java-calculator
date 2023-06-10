package com.programmers.exception;

public class MenuFormatException extends RuntimeException {
    private static final String MSG = "올바른 값을 입력해주세요.";

    public MenuFormatException() {
        super(MSG);
    }
}
