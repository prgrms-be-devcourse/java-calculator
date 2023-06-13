package model.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private static final String MENU_PATTERN = "^[1-2]$";
    public static final String INVALID_MENU = "1 또는 2만 입력 가능합니다.";

    private final int menu;

    public Menu(String menu) {
        validNumber(menu, MENU_PATTERN);
        this.menu = Integer.parseInt(menu);
    }

    public int getMenu() {
        return menu;
    }

    private void validNumber(String menu, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(menu);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_MENU);
        }
    }
}
