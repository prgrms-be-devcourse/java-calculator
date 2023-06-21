package com.programmers.domain;

import java.util.Arrays;

public enum Menu {
    HISTORY(1, "조회"),
    CALCULATE(2, "계산"),
    FINISH(3, "종료");

    private final int num;
    private final String name;

    Menu(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public boolean isHistory() {
        return this.equals(HISTORY);
    }

    public boolean isFinish() {
        return this.equals(FINISH);
    }

    public boolean isCalculate() {
        return this.equals(CALCULATE);
    }

    public static Menu getMenu(int num) {
        return Arrays
                .stream(Menu.values())
                .filter(m -> m.num == num)
                .findAny()
                .get();
    }

}
