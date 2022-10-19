package calculator.domain;

import java.util.Arrays;

public enum MenuType {
    MENU_RECORD("1"),
    MENU_CALCULATE("2"),
    END_PROGRAM("3");

    private final String menuCommand;

    MenuType(String menu) {
        this.menuCommand = menu;
    }

    public static MenuType from(String menuCommand) {
        return Arrays.stream(MenuType.values())
            .filter(type -> type.menuCommand.equals(menuCommand))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("\n[ERROR] 1, 2, 3번 중 선택하세요.\n"));
    }
}
