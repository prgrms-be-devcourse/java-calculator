package com.waterfogsw.exception;

public class InvalidMenuInput extends Exception {
    // 메뉴 입력이 잘못되었을 경우
    public InvalidMenuInput() {
    }

    public InvalidMenuInput(String msg) {
        super(msg);
    }
}
