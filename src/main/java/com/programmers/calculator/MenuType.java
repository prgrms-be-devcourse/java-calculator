package com.programmers.calculator;

import com.programmers.exception.WrongInputMenuException;

import java.util.Arrays;

public enum MenuType {
    HISTORY(1), CALCULATE(2), EXIT(3);

    private final int menuNumber;

    MenuType(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public static MenuType findMenuType(String inputNumber) {

        int inputMenuNumber = convertMenuNumber(inputNumber);

        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.menuNumber == inputMenuNumber)
                .findAny()
                .orElseThrow(() -> new WrongInputMenuException("잘못된 입력 메뉴가 들어왔습니다. 1, 2, 3 만 가능합니다."));
    }

    private static int convertMenuNumber(String inputNumber) {
        int convertInputNumber;
        try {
            convertInputNumber = Integer.parseInt(inputNumber);
        } catch(NumberFormatException e) {
            throw new WrongInputMenuException("잘못된 입력 메뉴가 들어왔습니다. 1, 2, 3 만 가능합니다.");
        }
        return convertInputNumber;
    }
}
