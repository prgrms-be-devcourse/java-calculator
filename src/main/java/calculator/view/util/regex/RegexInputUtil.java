package calculator.view.util.regex;

import java.util.regex.Pattern;

public class RegexInputUtil {

    private static final Pattern REGEX_MENU_INPUT = Pattern.compile("^[0-9]+$");

    public static boolean checkWrong(String value) {
        return !REGEX_MENU_INPUT.matcher(value).find();
    }
}
