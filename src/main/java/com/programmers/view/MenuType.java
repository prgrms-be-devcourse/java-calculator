package com.programmers.view;

import java.util.Arrays;

public enum MenuType {
    조회("1"), 계산("2"), 종료("3");

    private final String selectNumber;

    MenuType(String selectNumber) {
        this.selectNumber = selectNumber;
    }

    public static boolean containMenuNum(String number) {
        if (Arrays.asList(MenuType.values())
                .stream()
                .map(menuType -> menuType.selectNumber)
                .anyMatch(selectNumber -> selectNumber.equals(number))) {
            return true;
        }
        return false;
    }

}
