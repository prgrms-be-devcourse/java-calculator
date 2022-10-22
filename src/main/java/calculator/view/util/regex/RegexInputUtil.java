package calculator.view.util.regex;

import java.util.regex.Pattern;

public class RegexInputUtil {

    public static final Pattern REGEX_MENU_INPUT = Pattern.compile("^[0-9]+$");

    public static boolean checkWrong(Pattern pattern, String value) {
        return !pattern.matcher(value).find();
    }
}
