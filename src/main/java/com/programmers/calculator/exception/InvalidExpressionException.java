package com.programmers.calculator.exception;

public class InvalidExpressionException extends IllegalArgumentException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}
