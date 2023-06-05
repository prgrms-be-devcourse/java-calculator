package util;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum Menu {
    SEARCH("1"),
    CALC("2"),
    EMPTY("");

    private final String number;

    Menu(String number) {
        this.number = number;
    }

    public static Menu getMenu(String value) {
        return Arrays.stream(Menu.values())
                .filter(menu -> value.equals(menu.getNumber()))
                .findAny()
                .orElse(EMPTY);
    }

    public String getNumber() {
        return this.number;
    }
}
