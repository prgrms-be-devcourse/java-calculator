package calculator.menu;

import calculator.view.input.MenuInput;

import java.util.Arrays;
import java.util.Objects;

import static calculator.exception.MenuException.MENU_FIND_NULL_EXCEPTION;

public enum MenuEnum {

    MENU_CALCULATOR(1L, new MenuCalculator()),
    MENU_HISTORY_FINDER(2L, new MenuHistoryFinder());

    private final Long id;
    private final Menu menu;

    MenuEnum(Long id, Menu menu) {
        this.id = id;
        this.menu = menu;
    }

    public static void process() {
        Long menuId = askMenuId();
        findMenuById(menuId).process();
    }

    private static Menu findMenuById(Long id) {
        return Arrays.stream(MenuEnum.values())
                .filter(menu -> Objects.equals(menu.id, id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MENU_FIND_NULL_EXCEPTION.message))
                .menu;
    }

    private static MenuInput menuInput() {
        return new MenuInput();
    }

    private static Long askMenuId() {
        return menuInput().inputMenuNumber();
    }

}
