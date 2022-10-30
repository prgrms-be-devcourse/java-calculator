package com.programmers.calculator.engine.menu;

import com.programmers.calculator.utils.InputException;

import java.util.Arrays;

public enum Menu {
    //조회
    LOOKUP("1"),

    //계산
    CALCULATION("2"),

    //종료
    END("3");

    private String commandInput;

    Menu(String commandInput) {
        this.commandInput = commandInput;
    }

    @Override
    public String toString() {
        return commandInput;
    }

    public static String chooseMenu(String commandInput) {
        return getMenu(commandInput).toString();
    }

    private static Menu getMenu(String command) {
        return Arrays.stream(values())
                .filter(o -> o.commandInput.equals(command))
                .findFirst().orElseThrow(() -> new RuntimeException(new InputException("없는 메뉴 선택")));
    }
}
