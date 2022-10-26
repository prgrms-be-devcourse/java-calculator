package com.programmers.calculator.utils;

public class InputException extends Exception {

    private String message;

    public InputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
