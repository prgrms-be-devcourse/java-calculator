package com.programmers.calculator;

import com.programmers.exception.WrongInputMenuException;

import java.util.Arrays;

public enum MenuType {
    HISTORY("1"), CALCULATE("2"), EXIT("3");

    private final String menuNumber;

    MenuType(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    public static MenuType findMenuType(String inputNumber) {

        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.menuNumber.equals(inputNumber))
                .findAny()
                .orElseThrow(() -> new WrongInputMenuException("잘못된 입력 메뉴가 들어왔습니다. 1, 2, 3 만 가능합니다."));
    }
}
