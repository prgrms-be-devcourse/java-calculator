package com.programmers.calculator.exception;

public class ValidationException extends Exception {
    private static final long serialVersionUID = 2411024778226432444L;

    public ValidationException() {
        super("유효하지 않은 식입니다.");
    }
}
