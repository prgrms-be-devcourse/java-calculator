package com.programmers.cal.view;

public enum OutputMessage {

    READY("1. 조회\n2. 계산\n3. 그만하기\n선택 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
