package com.javacalculator.domain;

import java.util.Arrays;

public enum Menu {
    HISTORY("조회", 1),
    CALCULATION("계산", 2),
    END("종료", 9999);

    private final String name;
    private final int number;

    Menu(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Menu from(int number) {
        return Arrays.stream(values())
                .filter(menu -> menu.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴에 존재하지 않는 번호입니다. : " + number));
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
