package com.devcourse.valid;

import java.util.regex.Pattern;

public class MenuValidator {

    private static final String MENU_RANGE = "[1,2]";

    public static boolean valid(String menuNumber) {
        return Pattern.matches(MENU_RANGE, menuNumber);
    }
}
