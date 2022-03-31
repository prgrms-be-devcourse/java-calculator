package com.caculator;

public final class ErrorMessage {

    // 인스턴스 생성을 막기 위한 생성자
    private ErrorMessage() {}

    public static String DIVIDE_ZERO_ERROR_MESSAGE = "0으로 나누는 연산은 할 수 없습니다";
    public static String INCORRECT_COMMAND_ERROR_MESSAGE = "올바른 메뉴를 입력해주세요.";
    public static String INCORRECT_EXPRESSION_ERROR_MESSAGE = "올바른 수식을 입력해주세요";
    public static String EMPTY_HISTORY_MESSAGE = "계산 기록이 없습니다.";
}
