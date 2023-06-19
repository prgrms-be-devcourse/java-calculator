package com.programmers.exception;

public class MenuFormatException extends RuntimeException {
    private static final String MSG = "선택지에 해당하는 값을 입력해주세요.";

    public MenuFormatException() {
        super(MSG);
    }
}
