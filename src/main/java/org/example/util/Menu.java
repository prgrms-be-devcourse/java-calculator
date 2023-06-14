package org.example.util;

import java.util.Arrays;

public enum Menu {
    QUERY("1"),
    CALCULATE("2"),
    EXIT("3");

    private String number;

    Menu(String number) {
        this.number = number;
    }

    public static Menu getMenu(String str){
        return Arrays.stream(Menu.values())
                .filter((a) -> a.number.equals(str))
                .findFirst()
                .get();
    }
}
