package calculator.menu;

import java.util.Arrays;

import static calculator.exception.MenuException.MENU_FIND_NULL_EXCEPTION;

public enum MenuEnum {

    MENU_CALCULATOR(1, new MenuCalculator()),
    MENU_HISTORY_FINDER(2, new MenuHistoryFinder());

    private final int id;
    private final Menu menu;

    MenuEnum(int id, Menu menu) {
        this.id = id;
        this.menu = menu;
    }

    public static void process(int id) {
        findMenuById(id).menu.process();
    }

    private static MenuEnum findMenuById(int id) {
        return Arrays.stream(MenuEnum.values())
                .filter(menu -> menu.id == id)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MENU_FIND_NULL_EXCEPTION.message));
    }

}
