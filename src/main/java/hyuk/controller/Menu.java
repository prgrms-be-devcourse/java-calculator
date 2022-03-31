package hyuk.controller;

import java.util.Arrays;

public enum Menu {
    PRINT("1"),
    CALCULATE("2");

    private final String textMenu;

    Menu(final String textMenu) {
        this.textMenu = textMenu;
    }

    public static Menu of(final String symbol) {
        return Arrays.stream(values())
            .filter(menu -> menu.isTextMenu(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("해당 메뉴를 찾을 수 없습니다."));
    }

    private boolean isTextMenu(String symbol) {
        return textMenu.equals(symbol);
    }

    public boolean isPrint() {
        return (textMenu.equals("1"));
    }
}
