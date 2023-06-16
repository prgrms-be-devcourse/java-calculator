package com.programmers.util;

import com.programmers.exception.MenuFormatException;

import java.util.Arrays;

public enum Menu {
    HISTORY("1", "1. 조회"),
    CALCULATE("2", "2. 계산"),
    END("3", "3. 종료");

    public String getNumber() {
        return number;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    private final String number;
    private final String printMessage;

    Menu(String number, String printMessage) {
        this.number = number;
        this.printMessage = printMessage;
    }

    public static Menu getMenu(Request request) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getNumber().equals(request.getRequest()))
                .findAny()
                .orElseThrow(()-> new MenuFormatException());
    }

}
