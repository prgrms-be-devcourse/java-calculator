package com.programmers.exception;

public class ExpressionOtherCharacterException extends IllegalArgumentException {

    private static final String EXPRESSION_OTHER_CHARACTER_ERROR_MESSAGE = "\n[ERROR] 연산자와 숫자가 아닌 문자가 입력되어 있습니다.";

    public ExpressionOtherCharacterException() {
        super(EXPRESSION_OTHER_CHARACTER_ERROR_MESSAGE);
    }
}
