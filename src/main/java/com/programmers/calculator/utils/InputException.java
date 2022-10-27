package com.programmers.calculator.utils;

public class InputException extends Exception {
    //올바른 예외 처리 방식인지?? Enum을 사용하는 방법이 생각은 나는데 구체적으로 떠오르지 않습니다.

    private String message;

    public InputException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
