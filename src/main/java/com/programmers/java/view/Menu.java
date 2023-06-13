package com.programmers.java.view;

import java.util.Arrays;
import java.util.Optional;

public enum Button {
    SEARCH("1"), CALCULATE("2");
    private final String value;

    Button(String value) {
        this.value = value;
    }

    public static Optional<Button> findByValue(String selected) {
        return Arrays.stream(Button.values())
                .filter(v -> v.value.equals(selected))
                .findFirst();
    }

    @Override
    public String toString() {
        return value+". " + name();
    }
}