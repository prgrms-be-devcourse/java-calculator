package com.programmers.calculator.domain;

import com.programmers.calculator.constant.ErrorMessage;
import com.programmers.calculator.exception.InvalidMenuException;

import java.util.Arrays;

public enum Menu {
    HISTORY("1", "조회"),
    CALCULATE("2", "계산"),
    EXIT("3", "종료");

    private final String menuNumber;
    private final String text;

    Menu(String menuNumber, String text) {
        this.menuNumber = menuNumber;
        this.text = text;
    }

    public String getMenuNumber() {
        return menuNumber;
    }

    public String getText() {
        return text;
    }

    public static Menu findByNumber(String menuNumber) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.equals(menuNumber))
                .findFirst()
                .orElseThrow(() -> new InvalidMenuException(ErrorMessage.INVALID_MENU_NUMBER));
    }

    private boolean equals(String menuNumber) {
        return this.menuNumber.equals(menuNumber);
    }
}
