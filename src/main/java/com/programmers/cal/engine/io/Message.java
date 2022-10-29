package com.programmers.cal.engine.io;

import lombok.ToString;

public enum Message {
    MENU_MESSAGE("\n번호를 입력하세요\n1. 조회\n2. 계산\n3. 종료\n선택 : "),
    WRONG_ORDER_MESSAGE("잘못된 입력입니다."),
    EXIT_MESSAGE("종료되었습니다."),
    ZERO_MESSAGE("0으로 나눌 수 없습니다."),
    NO_RECORD_MESSAGE("데이터가 없습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
