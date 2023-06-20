package com.programmers.error;

public final class ErrorMessages {

    private static final String INVALID_MENU_SELECTION = "메뉴를 잘못 선택하셨습니다. 메뉴는 1,2,3 중에서 선택 가능합니다.";
    private static final String ENTER_ZERO_FOR_DIVISION = "0으로는 나눌 수 없습니다. 0이 아닌 다른 숫자를 사용해 주세요.";
    private static final String INVALID_OPERATOR_INPUT = "잘못된 수식입니다. +, -, *, / 연산만 가능합니다.";
    private static final String NO_CALCULATION_RECORDS = "계산 기록이 없습니다. 먼저 계산 결과를 얻은 후 사용하세요.";
    private static final String OPERAND_IS_NOT_A_NUMBER = "피연산자가 숫자가 아닙니다. 숫자를 입력해 주세요.";

    private ErrorMessages() {
        throw new RuntimeException("ErrorMsg를 인스턴스화 하지 마세요");
    }

    public static String getInvalidMenuSelectionMsg() {
        return INVALID_MENU_SELECTION;
    }

    public static String getEnterZeroForDivisionMsg() {
        return ENTER_ZERO_FOR_DIVISION;
    }

    public static String getInvalidOperatorInputMsg() {
        return INVALID_OPERATOR_INPUT;
    }

    public static String getNoCalculationRecordsMsg() {
        return NO_CALCULATION_RECORDS;
    }

    public static String getOperandIsNotANumberMsg() {
        return OPERAND_IS_NOT_A_NUMBER;
    }
}
