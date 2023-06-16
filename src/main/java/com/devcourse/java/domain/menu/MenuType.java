package com.devcourse.java.domain.menu;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum MenuType {
    QUERY("1"),
    CALCULATE("2"),
    NONE("")
    ;

    private final String type;

    MenuType(String type) {
        this.type = type;
    }

    public static MenuType from(String type) {
        return Arrays.stream(MenuType.values())
                .filter(menu -> StringUtils.equals(menu.type, type))
                .findFirst()
                .orElse(NONE);
    }

    public boolean isNotOnMenu() {
        return this == NONE;
    }
}
