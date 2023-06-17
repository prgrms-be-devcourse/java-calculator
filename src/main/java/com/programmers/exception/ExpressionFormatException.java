package com.programmers.exception;

public class ExpressionFormatException extends IllegalArgumentException {

    private static final String EXPRESSION_FORMAT_ERROR_MESSAGE = "\n[ERROR] 계산식의 형식에 맞지 않습니다.";

    public ExpressionFormatException() {
        super(EXPRESSION_FORMAT_ERROR_MESSAGE);
    }
}
