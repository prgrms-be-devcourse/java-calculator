package calculator.menu;

import calculator.view.input.MenuInput;
import calculator.view.output.MenuOutput;

import java.util.Arrays;
import java.util.Objects;

import static calculator.exception.MenuException.MENU_FIND_NULL_EXCEPTION;

public enum Menus {

    MENU_HISTORY_FINDER(1, "조회", new MenuHistoryFinder()),
    MENU_CALCULATOR(2,"계산", new MenuCalculator());

    private static final MenuInput menuInput = new MenuInput();
    private static final MenuOutput menuOutput = new MenuOutput();
    private final int id;
    private final String title;
    private final Menu menu;

    Menus(int id, String title, Menu menu) {
        this.id = id;
        this.title = title;
        this.menu = menu;
    }

    public static void process() {
        menuOutput.printMenus();
        menuOutput.printSelectedSign();
        int menuId = menuInput.askMenuId();
        Menu findMenu = findMenuById(menuId);
        menuOutput.printAfter();

        findMenu.process();
    }

    private static Menu findMenuById(int id) {
        return Arrays.stream(Menus.values())
                .filter(menu -> Objects.equals(menu.id, id))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(MENU_FIND_NULL_EXCEPTION.getMessage()))
                .menu;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
