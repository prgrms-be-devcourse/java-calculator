package com.programmers.exception;

public class WrongInputExpressionException extends IllegalArgumentException {
    public WrongInputExpressionException(String message) {
        super(message);
    }
}
