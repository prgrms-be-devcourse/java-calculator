package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuVO {
    private static final String BUTTON_PATTERN = "^[1-2]$";
    public static final String INVALID_INPUT_BUTTON = "1 또는 2만 입력 가능합니다.";

    private final int menu;

    public MenuVO(String menu) {
        validNumber(menu, BUTTON_PATTERN);
        this.menu = Integer.parseInt(menu);
    }

    public int getMenu() {
        return menu;
    }

    private void validNumber(String menu, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(menu);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_INPUT_BUTTON);
        }
    }
}
