package com.programmers.oop.message;

public enum FrontMessage {
    MENU_LIST("1. 조회\n2. 계산\n\n선택 : "),
    FORMULA("\n");

    String message;

    FrontMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
