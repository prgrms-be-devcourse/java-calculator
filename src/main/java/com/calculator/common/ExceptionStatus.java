package com.calculator.common;

public enum ExceptionStatus {
    INPUT_TYPE_ERROR("없는 메뉴 숫자입니다."),
    DIVIDE_ZERO_ERROR("0으로 나눌 수 없습니다."),
    NOT_NUM_ERROR("숫자와 연산자만 입력해주세요."),
    INVALID_OPERATOR("존재하지 않는 연산자입니다.");


    private final String message;

    ExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
