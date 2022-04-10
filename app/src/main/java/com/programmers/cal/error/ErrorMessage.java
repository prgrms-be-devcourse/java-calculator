package com.programmers.cal.error;

public enum ErrorMessage {

    MENU_ERROR_MESSAGE("메뉴 선택이 올바르지 않습니다."),
    FORMULA_ERROR_MESSAGE("수식이 올바르지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
