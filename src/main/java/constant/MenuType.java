package constant;

import java.util.Arrays;

public enum MenuType {
    CHECK_DATA(1),
    CALCULATION(2);

    private final int menu;

    MenuType(int menu) {
        this.menu = menu;
    }

    public int getMenu() {
        return menu;
    }

    public static MenuType findMenuType(int inputMenu) {
        return Arrays.stream(values())
                .filter(menuType -> menuType.menu == inputMenu)
                .findAny()
                .get();
    }
}
