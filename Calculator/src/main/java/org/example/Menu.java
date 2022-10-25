package org.example;

public enum Menu {
    HISTORY(1),
    CALCULATE(2);

    private final int number;

    Menu(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
