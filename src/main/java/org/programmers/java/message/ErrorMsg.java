package org.programmers.java.message;

public enum ErrorMsg {
    CALCULATE_VALIDATION_ERROR_MSG("잘못된 입력 값 입니다. 형식을 맞춰주세요. ex) 2 + 4 ..."),
    SELECT_VALIDATION_ERROR_MSG("잘못된 입력 값 입니다. 1-3 사이의 숫자를 선택해주세요");

    private final String errorMsg;

    ErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
