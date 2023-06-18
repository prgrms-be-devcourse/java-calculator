package com.programmers.engine.exception;

import lombok.Getter;

@Getter
public enum CalculatorErrorCode {

    SELECTION_ERROR("1 또는 2 를 입력해 주세요"),
    COMMAND_ERROR("잘못된 계산식 입니다."),
    OPERATOR_ERROR("잘못된 연산자 입니다.");

    private String errorMessage;

    CalculatorErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
