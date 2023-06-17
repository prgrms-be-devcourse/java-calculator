package io;

public enum Menu {
    QUERY(1),
    CALCULATE(2),
    EXIT(3);

    private final int menuNumber;

    Menu(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public int getMenuNumber() {
        return menuNumber;
    }
}
