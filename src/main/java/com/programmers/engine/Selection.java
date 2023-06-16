package com.programmers.engine;

public enum Selection {
    HISTORY("1"), CALCULATION("2");

    private String number;

    Selection(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
