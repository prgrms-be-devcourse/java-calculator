package com.programmers.exception;

public class SelectionEmptyException extends IllegalArgumentException {

    private static final String SELECTION_EMPTY_ERROR_MESSAGE = "\n[ERROR] 메뉴 번호가 입력되지 않았습니다.\n";

    public SelectionEmptyException() {
        super(SELECTION_EMPTY_ERROR_MESSAGE);
    }
}
