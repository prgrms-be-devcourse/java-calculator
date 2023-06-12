package com.devcourse.engine.model;

public enum Menu {
    EXIT("0", "종료"),
    HISTORY("1", "조회"),
    COMPUTE("2", "계산");

    private final String menuOrdinal;
    private final String menuValue;

    Menu(String ordinal, String value) {
        this.menuOrdinal = ordinal;
        this.menuValue = value;
    }

    public String getMenuValue() {
        return menuValue;
    }

    public String getMenuOrdinal() {
        return menuOrdinal;
    }
}
