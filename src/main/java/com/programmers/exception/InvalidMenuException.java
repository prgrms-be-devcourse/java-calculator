package com.programmers.exception;

public class InvalidMenuException extends IllegalArgumentException {
    public InvalidMenuException(String message) {
        super(message);
    }
}
