package com.programmers.java.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Menu {
    SELECT("1", "조회"),
    CALCULATE("2", "계산");

    private String menuNum;
    private String menuName;

    Menu(String menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public static Menu getMenu(String menuNum) {
        return Arrays.stream(values())
                .filter(o -> Objects.equals(o.menuNum, menuNum))
                .findFirst().get();
    }
}
