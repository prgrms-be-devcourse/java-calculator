package com.programmers.exception;

public class WrongOperationException extends IllegalArgumentException {

    public WrongOperationException(String message) {
        super(message);
    }
}
