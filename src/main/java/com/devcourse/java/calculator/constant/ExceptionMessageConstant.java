package com.devcourse.java.calculator.constant;

public final class ExceptionMessageConstant {

    private ExceptionMessageConstant() {
    }

    public static final String COMMAND_INPUT_NOT_INTEGER_EXCEPTION = "[ERROR] 메뉴 - 올바른 입력 형식(정수)이 아닙니다.";
    public static final String COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION = "[ERROR] 메뉴 - 1 이상 3 이하의 정수를 입력하세요.";
    public static final String EMPTY_CALCULATE_HISTORY_EXCEPTION = "[ERROR] 메뉴 - 조회할 계산 내역이 없습니다.";
    public static final String WRONG_EQUATION_INPUT_EXCEPTION = "[ERROR] 계산 - 올바른 식이 아닙니다.";
    public static final String DIVIDE_BY_ZERO_EXCEPTION = "[ERROR] 계산 - 0으로 나눌 수 없습니다.";

}
