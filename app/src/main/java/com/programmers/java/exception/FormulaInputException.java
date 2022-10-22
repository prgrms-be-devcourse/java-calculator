package com.programmers.java.exception;

public class FormulaInputException extends Exception {
    private static final String errorMessage = "잘못된 계산식입니다.";

    public FormulaInputException() {
        super(errorMessage);
    }
}
