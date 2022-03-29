package com.programmers.calculator.exception.validation;

public class ValidationException extends Exception {
    private static final long serialVersionUID = 2411024778226432444L;

    public ValidationException(String message) {
        super(message);
    }
}
