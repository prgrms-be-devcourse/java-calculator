package util;

import java.util.Arrays;

public enum Menu {
    SEARCH("1", "1. 조회"),
    CALC("2", "2. 계산"),
    END("3", "3. 종료");

    private final String number;
    private final String printMsg;

    Menu(String number, String printMsg) {
        this.printMsg = printMsg;
        this.number = number;
    }

    public static Menu getMenu(String value) {
        return Arrays.stream(Menu.values())
                .filter(menu -> value.equals(menu.getNumber()))
                .findAny()
                .orElseThrow(()->new IllegalException(ExceptionMsg.NotMenuFormatException));
    }

    public String getNumber() {
        return this.number;
    }

    public String getPrintMsg() {
        return this.printMsg;
    }
}
