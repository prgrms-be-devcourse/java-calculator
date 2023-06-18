package com.programmers.calculator.exception;

public class InvalidOperatorException extends IllegalArgumentException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}
