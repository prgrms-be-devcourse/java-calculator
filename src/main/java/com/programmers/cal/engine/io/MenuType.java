package com.programmers.cal.engine.io;

import com.programmers.cal.engine.exception.WrongOrderException;
import lombok.Getter;

@Getter
public enum MenuType {

    PRINT_RECORD("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String menuType;

    MenuType(String menuType) {
        this.menuType = menuType;
    }

    public static MenuType getMenuType(String inputString) {
        for (MenuType type : MenuType.values()) {
            if (type.getMenuType().equals(inputString)) return type;
        }
        throw new WrongOrderException();
    }
}
