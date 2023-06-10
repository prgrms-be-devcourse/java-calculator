package org.calculator.engine.error;

public enum ErrorCode {
    BAD_CONDITION;

    public static void printError(ErrorCode errorCode) {
        if (errorCode == BAD_CONDITION) {
            System.out.println("잘못된 값을 입력했습니다. 다시 확인해주세요");
        }

    }
}
