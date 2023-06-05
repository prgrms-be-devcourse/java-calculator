package org.error;

public enum ResponseErrorFormat {

    ERROR_DIVISION_BY_ZERO("0으로는 나눌 수 없습니다."),
    ERROR_BAD_OPERATOR("잘못된 연산자입니다."),
    ;

    private String message;

    ResponseErrorFormat(String message) {

        this.message = message;
    }
}
