package com.programmers.exception;

public class SelectionFormatException extends IllegalArgumentException {

    private static final String SELECTION_FORMAT_ERROR_MESSAGE = "\n[ERROR] 메뉴 번호가 형식에 맞지 않습니다.\n";

    public SelectionFormatException() {
        super(SELECTION_FORMAT_ERROR_MESSAGE);
    }
}
