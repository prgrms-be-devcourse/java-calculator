package calculator.entity;

import static calculator.validation.MenuInputValidator.validateIsExistedMenu;

public enum Menu {

    READ_HISTORY(1, "조회"),
    CALCULATE(2, "계산");

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

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "." + name;
    }
}
