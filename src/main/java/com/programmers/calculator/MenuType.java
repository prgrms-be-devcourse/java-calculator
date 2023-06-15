package com.programmers.calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MenuType {
    HISTORY("1"), CALCULATE("2"), EXIT("3"), NULL("999");

    private final String menuNumber;
    private final static Map<String, MenuType> MENU_TYPE_MAP =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(MenuType::getMenuNumber, Function.identity())));

    MenuType(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    public static MenuType findMenuType(String inputNumber) {

        if (!MENU_TYPE_MAP.containsKey(inputNumber)) {
            return MenuType.NULL;
        }

        return MENU_TYPE_MAP.get(inputNumber);
    }

    private String getMenuNumber() {
        return menuNumber;
    }
}
