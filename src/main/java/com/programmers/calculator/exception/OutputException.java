package com.programmers.calculator.exception;

public class OutputException extends Exception {
    private static final long serialVersionUID = -1252290174584837515L;

    public OutputException() {
        super("저장된 데이터가 없습니다.");
    }
}
