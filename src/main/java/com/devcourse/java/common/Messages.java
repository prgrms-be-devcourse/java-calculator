package com.devcourse.java.common;

public enum Messages {
    MENU_SELECTION("1: 조회\n2: 계산\n\n선택 : "),
    EXIT_CONFIRM("메뉴에 없는 값을 입력했습니다.\n종료하시겠습니까? (Y) : "),
    EXITING("계산기를 종료합니다."),
    EMPTY_STORAGE("계산 이력이 없습니다.\n\n"),
    BAD_EXPRESSION("올바른 계산식이 아닙니다. 다시 입력바랍니다.\n\n")
    ;

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String toMessage() {
        return this.message;
    }
}
