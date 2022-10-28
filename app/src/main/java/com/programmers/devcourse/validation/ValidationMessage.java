package com.programmers.devcourse.validation;

public enum ValidationMessage {
    EMPTY("입력값이 없습니다."),
    NOT_VALID_TOKEN("사칙연산자, 소괄호, 정수만 입력가능합니다.");

    String messageStr;
    ValidationMessage(String messageStr) {
        this.messageStr = messageStr;
    }
}
