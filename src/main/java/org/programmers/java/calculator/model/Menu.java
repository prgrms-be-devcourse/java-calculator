package org.programmers.java.calculator.model;

import java.util.Arrays;

public enum Menu {

    MEMORY(1),
    CALCULATE(2),
    EXIT( 3),
    ERROR(-1);

    private static final int BAD_REQUEST = -1;

    private final int code;

    Menu(int code) {
        this.code = code;
    }

    public static Menu selectMenu(String input) {
        int code = toCode(input);
        return Arrays.stream(Menu.values())
                .filter(meun -> meun.code == code)
                .findFirst()
                .orElse(ERROR);
    }

    private static int toCode(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return BAD_REQUEST;
        }
    }
}
