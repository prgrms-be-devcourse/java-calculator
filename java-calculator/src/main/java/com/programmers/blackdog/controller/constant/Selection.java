package com.programmers.blackdog.controller.constant;

import java.util.Arrays;

public enum Selection {
    CHECK_DATA(1), CALCULATE(2), EXIT(3);

    private final int code;

    Selection(int code) {
        this.code = code;
    }

    public static Selection findByCode(int code) {
        return Arrays.stream(Selection.values())
                .filter(selection -> selection.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 값이 없습니다"));
    }
}
