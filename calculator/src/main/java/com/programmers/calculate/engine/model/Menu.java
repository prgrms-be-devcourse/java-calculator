package com.programmers.calculate.engine.model;

public enum Menu {
    LOOK_UP("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String value;

    Menu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
