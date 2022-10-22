package com.programmers.java.exception;

public class ChosenNumberNotInMenuException extends Exception {
    private static final String errorMessage = "메뉴에 있는 숫자를 입력해주세요.";

    public ChosenNumberNotInMenuException() {
        super(errorMessage);
    }
}
