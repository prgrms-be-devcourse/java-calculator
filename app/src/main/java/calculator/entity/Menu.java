package calculator.entity;

import calculator.validation.exception.MenuInputException;

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
        Menu selectedMenu = null;

        for (Menu menu : Menu.values()) {
            if (selectedMenuNumber == menu.getNumber()) {
                selectedMenu = menu;
                break;
            }
        }

        validateIsExistedMenu(selectedMenu);

        return selectedMenu;
    }

    private static void validateIsExistedMenu(Menu selectedMenu) {
        if (selectedMenu == null) {
            throw new MenuInputException(NOT_EXIST_MENU_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "." + name;
    }
}
