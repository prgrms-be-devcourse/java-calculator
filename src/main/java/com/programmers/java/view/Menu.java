package com.programmers.java.view;

import java.util.Arrays;
import java.util.Optional;

public enum Menu {
    SEARCH("1"), CALCULATE("2");

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public static Optional<Menu> findByValue(String selected) {
        return Arrays.stream(Menu.values())
                .filter(v -> v.value.equals(selected))
                .findFirst();
    }

    @Override
    public String toString() {
        return value + ". " + name();
    }
}