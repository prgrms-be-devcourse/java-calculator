package com.programmers.java.view;


public enum Button {
    SEARCH("1"), CALCULATE("2");
    private final String value;

    Button(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}