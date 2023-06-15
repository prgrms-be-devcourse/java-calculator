package org.programmers.constant;

import java.util.Arrays;

public enum Selection {
    ERROR(0), HISTORY(1), CALCULATION(2), EXIT(3);

    private final int code;

    Selection(int code) {
        this.code = code;
    }

    public static Selection find(int code) {
        return Arrays.stream(Selection.values())
                .filter(selection -> selection.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 메뉴 번호가 입력되었습니다."));
    }
}
