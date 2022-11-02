package com.programmers.java.engine.util;

import com.programmers.java.engine.exception.MenuException;

import java.util.Arrays;

public enum Menu {
    LOOKUP("1"),
    COMPUTE("2"),
    EXIT("3"),
    GUIDE("\n1. 조회\n2. 계산\n3. 종료\n\n선택 : ");

    private final String select;

    Menu(String select) {
        this.select = select;
    }

    public static Menu findMenu(String command) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.select.equals(command))
                .findAny()
                .orElseThrow(() -> new MenuException("올바른 메뉴를 선택해주세요.\n"));
    }

    public String get() {
        return this.select;
    }
}
