package com.programmers.oop.message;

public enum FrontMessage {
    MENU_LIST("1. 조회\n2. 계산\n\n선택 : "),
    FORMULA("\n"),
    RESULT_LINE("\n\n"),
    NOT_EXIST_DATA("데이터가 존재하지 않습니다.\n\n"),
    CLIENT_ERROR("잘못된 입력입니다. 종료를 원하시면 '-1'을 입력해주세요.\n\n");

    String message;

    FrontMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
