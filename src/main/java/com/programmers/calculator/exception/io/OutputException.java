package com.programmers.calculator.exception.io;

public class OutputException extends Exception {
    private static final long serialVersionUID = -1252290174584837515L;
    public static final String MESSAGE = "저장된 데이터가 없습니다.";

    public OutputException() {
        super(MESSAGE);
    }
}
