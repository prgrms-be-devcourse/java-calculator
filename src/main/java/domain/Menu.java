package main.java.domain;

import java.util.Arrays;

// 메뉴도 하나의 Data 단위.
public enum Menu {
    SELECT(-1, "선택 : "),
    EXIT(0, "종료"),
    SHOW(1, "조회"),
    CALCULATE(2, "계산");

    private final int menuNum;
    private final String menuName;
    public static int menuCount = 3;

    Menu(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public int getMenuNum() {
        return menuNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public static Menu getMenu(int menu) {
        return Arrays.stream(values())
                .filter(value -> value.menuNum==(menu))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return menuNum + ". " + menuName;
    }
}
