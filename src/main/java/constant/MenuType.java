package constant;

import java.util.Arrays;

import static controller.CalculatorController.INVALID_MENU;

public enum MenuType {
    INQUIRY(1),
    CALCULATION(2);

    private final int menu;

    MenuType(int menu) {
        this.menu = menu;
    }

    public static MenuType findMenuType(int inputMenu) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.menu == inputMenu)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU));
    }
}
