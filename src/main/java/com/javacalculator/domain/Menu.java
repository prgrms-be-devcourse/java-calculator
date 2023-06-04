package com.javacalculator.domain;

public enum Menu {
    FIRST("조회", 1),
    SECOND("계산", 2);

    private final String name;
    private final int number;

    Menu(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
