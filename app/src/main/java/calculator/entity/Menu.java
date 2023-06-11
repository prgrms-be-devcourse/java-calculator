package calculator.entity;

import calculator.validation.exception.MenuInputException;
import java.util.Arrays;
import java.util.Optional;

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

    public static boolean isQuit(Optional<Menu> selectedMenu) {
        return selectedMenu.equals(Optional.of(Menu.QUIT));
    }

    public static Optional<Menu> getSelectedMenu(int selectedMenuNumber) {
        Optional<Menu> selectedMenu = Arrays.stream(Menu.values())
            .filter(menu -> selectedMenuNumber == menu.getNumber())
            .findFirst();

        validateIsExistedMenu(selectedMenu);

        return selectedMenu;
    }

    private static void validateIsExistedMenu(Optional<Menu> selectedMenu) {
        if (selectedMenu.isEmpty()) {
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
