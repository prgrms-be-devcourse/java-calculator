package com.programmers.engine.model;

import java.util.Arrays;

public enum Menu {
    LOOK_UP("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String menu;

    Menu(String menu) {
        this.menu = menu;
    }

    public static Menu matchMenu(int number) {
        return Arrays.stream(values())
                .filter(v -> number == Integer.parseInt(v.menu))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
