package com.programmers.calculate.engine.model;

import java.util.Arrays;
import java.util.Objects;

public enum Menu {
    LOOK_UP("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public static Menu matchNumber(String selectNumber) {
        return Arrays.stream(values())
                .filter(v -> selectNumber.equals(v.value))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
