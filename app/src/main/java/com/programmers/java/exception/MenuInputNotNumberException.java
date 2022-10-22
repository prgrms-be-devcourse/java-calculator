package com.programmers.java.exception;

public class MenuInputNotNumberException extends Exception {
    private static final String errorMessage = "숫자를 입력해주세요.";

    public MenuInputNotNumberException() {
        super(errorMessage);
    }
}
