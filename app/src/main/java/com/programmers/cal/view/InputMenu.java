package com.programmers.cal.view;

import java.util.Arrays;
import java.util.Optional;

public enum InputMenu {

    LOOKUP("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String menu;

    InputMenu(String menu) {
        this.menu = menu;
    }

    static Optional<InputMenu> findOf(String menu) {
        return Arrays.stream(InputMenu.values()).filter(s -> s.menu.equals(menu)).findFirst();
    }

    public String getMenu() {
        return menu;
    }

}
