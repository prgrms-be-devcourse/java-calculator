package com.programmers.java.exception;

public class MenuInputException extends Exception {
    private static final String errorMessage = "번호를 다시 입력해주세요.";

    public MenuInputException() {
        super(errorMessage);
    }
}
