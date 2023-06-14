package com.programmers.error;


public enum ErrorMessage {
    NOT_VALID_ARITHMETIC_EXPRESSION("[error] 계산식이 옳지 않습니다."),
    NOT_INTEGER_EXCEPTION("[error] 정수가 아닙니다."),
    NOT_MENU_OPTION("[error] 없는 메뉴입니다."),
    DIVIDE_ZERO_EXCEPTION("[error] 0으로 나눌 수 없습니다."),
    INVALID_OPERATOR_EXCEPTION("[error] 연산자가 유효하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}