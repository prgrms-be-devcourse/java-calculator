package com.calculator.common;

public enum ExceptionStatus {
    INPUT_TYPE_ERROR("없는 메뉴 숫자입니다."),
    DIVIDE_ZERO_ERROR("0으로 나눌 수 없습니다."),
    NOT_NUM_ERROR("숫자와 연산자만 입력해주세요."),
    IO_ERROR("입력값을 확인해주세요.");

    private String message;

    private ExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
