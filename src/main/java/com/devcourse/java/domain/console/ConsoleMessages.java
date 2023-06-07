package com.devcourse.java.domain.console;

public enum ConsoleMessages {
    MENU_SELECTION("1: 조회\n2: 계산\n\n선택 : "),
    EXIT_CONFIRM("\n주어진 메뉴와 다른 값을 입력했습니다. \n종료하시겠습니까? (Y) : "),
    EXITING("계산기를 종료합니다.")
    ;

    private final String message;

    ConsoleMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
