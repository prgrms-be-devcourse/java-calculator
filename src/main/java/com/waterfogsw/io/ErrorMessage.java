package com.waterfogsw.io;

public class ErrorMessage {
    private ErrorMessage() {
        //유틸리티 클래스
    }

    static final String DIV_BY_ZERO = "0으로 나눌수 없습니다.\n";
    static final String WRONG_INPUT = "잘못된 입력입니다.\n";
    static final String DATA_OVERFLOW = "계산할 수 있는 데이터 범위를 초과하였습니다.\n";
}
