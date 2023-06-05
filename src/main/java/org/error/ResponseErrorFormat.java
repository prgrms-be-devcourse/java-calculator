package org.error;

public enum ResponseErrorFormat {

    ERROR_DIVISION_BY_ZERO("0으로는 나눌 수 없습니다."),
    ERROR_BAD_SYMBOL("잘못된 연산자입니다."),
    ERROR_NOT_FOUND_MENU("없는 메뉴입니다."),
    ERROR_BAD_OPERATION("잘못된 연산식입니다."),
    ;

    private String message;

    ResponseErrorFormat(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
