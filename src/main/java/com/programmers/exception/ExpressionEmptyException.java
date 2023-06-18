package com.programmers.exception;

public class ExpressionEmptyException extends IllegalArgumentException {

    private static final String EXPRESSION_EMPTY_ERROR_MESSAGE = "\n[ERROR] 계산식이 입력되지 않았습니다.";

    public ExpressionEmptyException() {
        super(EXPRESSION_EMPTY_ERROR_MESSAGE);
    }
}