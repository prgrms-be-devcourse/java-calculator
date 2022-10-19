package calculator.menu;

import calculator.exception.MenuException;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static calculator.exception.MenuException.*;

public enum MenuEnum {

    MENU_CALCULATOR(1, new MenuCalculator()),
    MENU_HISTORY_FINDER(2, new MenuHistoryFinder());

    private final int id;
    private final Menu menu;

    MenuEnum(int id, Menu menu) {
        this.id = id;
        this.menu = menu;
    }

    public static MenuEnum findMenuById(int id) {
        return Arrays.stream(MenuEnum.values())
                .filter(menu -> menu.id == id)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MENU_FIND_NULL_EXCEPTION.message));
    }

}
