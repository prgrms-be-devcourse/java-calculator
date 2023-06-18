package com.devcourse.engine.model.unit;

import com.devcourse.engine.model.exception.InvalidInputException;

public enum Menu {
    EXIT("0", "종료"),
    HISTORY("1", "조회"),
    CALCULATE("2", "계산");

    private final String menuOrdinal;
    private final String menuValue;

    Menu(String ordinal, String value) {
        this.menuOrdinal = ordinal;
        this.menuValue = value;
    }

    public static Menu getMenuByOrdinalString(String ordinal) {
        return switch (ordinal) {
            case "0" -> EXIT;
            case "1" -> HISTORY;
            case "2" -> CALCULATE;
            default -> throw new InvalidInputException(InvalidInputException.INVALID_MENU);
        };
    }
}
