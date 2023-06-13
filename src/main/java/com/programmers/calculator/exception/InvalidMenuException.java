package com.programmers.calculator.exception;

public class InvalidMenuException extends IllegalArgumentException {
    public InvalidMenuException(String message) {
        super(message);
    }
}
