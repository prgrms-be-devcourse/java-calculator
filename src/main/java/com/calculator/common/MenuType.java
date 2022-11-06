package com.calculator.common;

import static com.calculator.common.ExceptionStatus.INPUT_TYPE_ERROR;

public enum MenuType {
    FIND("1", "조회"), CAL("2", "계산"), END("3", "끝");

    private final String num;
    private final String name;

    MenuType(String num, String name) {
        this.num = num;
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public static MenuType of(String num) {
        for (MenuType menuType : MenuType.values()) {
            if (menuType.getNum().equals(num)) {
                return menuType;
            }
        }

        throw new BusinessException(INPUT_TYPE_ERROR);
    }
}
