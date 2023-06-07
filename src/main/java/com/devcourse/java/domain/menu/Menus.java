package com.devcourse.java.domain.menu;

import java.util.Arrays;

public enum Menus {
    QUERY(1),
    CALCULATE(2),
    NONE(9999)
    ;

    private final int type;

    Menus(int type) {
        this.type = type;
    }

    public static Menus of(int type) {
        return Arrays.stream(Menus.values())
                .filter(menus -> menus.type == type)
                .findFirst()
                .orElse(NONE);
    }

    public boolean isNotOnMenu() {
        return this == NONE;
    }
}
