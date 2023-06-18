package com.devcourse.engine.model.exception;

public class InvalidInputException extends RuntimeException {

    public static final String INVALID_EXPRESSION = "올바르지 않은 식입니다.";
    public static final String NO_HISTORY = "표시할 이력이 없습니다.";
    public static final String INVALID_MENU = "올바른 메뉴를 선택해주세요.";
    public static final String ZERO_DIVIDE = "0으로 나눌 수 없습니다.";

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
