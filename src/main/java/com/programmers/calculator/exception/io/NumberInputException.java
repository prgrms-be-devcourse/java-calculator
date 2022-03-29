package com.programmers.calculator.exception.io;

public class NumberInputException extends InputException {
    private static final long serialVersionUID = -6008277195540542990L;
    public static final String MESSAGE = "번호 입력이 잘못되었습니다.";

    public NumberInputException() {
        super(MESSAGE);
    }
}
