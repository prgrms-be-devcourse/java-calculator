package com.programmers.java.calculator.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuType {

    HISTORY("1", "조회"),
    CALCULATE("2", "계산"),
    END("3", "종료");

    private final String number;
    private final String name;
    private static String menu = null;

    MenuType(String number, String name) {
        this.number = number;
        this.name = name;
    }

    private static final Map<String, MenuType> MENU_TYPE_MAP =
            Stream.of(values())
                    .collect(Collectors.toMap(MenuType::getNumber,
                            menuType -> menuType,
                            (x, y) -> y, LinkedHashMap::new));

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static String getMenu() {
        if (menu == null) {
            menu = createMenu();
        }

        return menu;
    }

    private static String createMenu() {
        StringBuilder builder = new StringBuilder();

        for (MenuType menuType : MENU_TYPE_MAP.values()) {
            builder.append(menuType.getNumber() + ". " + menuType.getName() + '\n');
        }
        builder.append("\n선택 : ");

        return builder.toString();
    }

    public static MenuType of(String number) {
        if (MENU_TYPE_MAP.containsKey(number))
            return MENU_TYPE_MAP.get(number);

        throw new IllegalArgumentException("메뉴를 찾을 수 없습니다.");
    }
}
