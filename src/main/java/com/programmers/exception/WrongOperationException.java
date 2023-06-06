package com.programmers.exception;

public class WrongOperationException extends IllegalArgumentException {

    public WrongOperationException(String s) {
        super(s);
    }
}
