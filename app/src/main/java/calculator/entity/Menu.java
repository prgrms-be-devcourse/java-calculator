package calculator.entity;

import calculator.exception.MenuInputException;
import java.util.Arrays;

public enum Menu {

    READ_HISTORY(1, "조회"),
    CALCULATE(2, "계산"),
    QUIT(3, "종료");

    private static final String NOT_EXIST_MENU_MESSAGE = "존재하지 않는 메뉴입니다.";
    private final int number;
    private final String name;

    Menu(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Menu getSelectedMenu(int selectedMenuNumber) {
        return Arrays.stream(Menu.values())
            .filter(menu -> selectedMenuNumber == menu.getNumber())
            .findFirst()
            .orElseThrow(() -> new MenuInputException(NOT_EXIST_MENU_MESSAGE));
    }

    public boolean isReadHistory() {
        return this == Menu.READ_HISTORY;
    }

    public boolean isCalculate() {
        return this == Menu.CALCULATE;
    }

    public boolean isQuit() {
        return this == Menu.QUIT;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "." + name;
    }
}
