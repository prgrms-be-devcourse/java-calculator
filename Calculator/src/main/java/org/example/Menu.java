package org.example;

import java.util.Arrays;

public enum Menu {
    HISTORY(1),
    CALCULATE(2),
    EXIT(3);

    private final int number;

    Menu(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Menu getMenu(int menuNumber) {
        return Arrays.stream(Menu.values())
                .filter(o -> o.number == menuNumber)
                .findFirst()
                .get();
    }
}
