package calulator.domain;

import java.util.Arrays;

public enum Menu {

    SELECT("조회", "1"), CALCULATE("계산", "2");

    private final String name;
    private final String value;

    Menu(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static String menuInfo() {
        StringBuilder menuInfo = new StringBuilder();
        for (Menu menu : Menu.values()) {
            menuInfo.append(menu.value).append(". ").append(menu.name).append("\n");
        }
        return menuInfo.toString();
    }

    public static Menu findMenu(String value) {
        return Arrays.stream(values())
                .filter(menu -> menu.value.equals(value))
                .findFirst()
                .orElse(null);
    }

    public boolean isNull() {
        return this.name.isEmpty();
    }

}
