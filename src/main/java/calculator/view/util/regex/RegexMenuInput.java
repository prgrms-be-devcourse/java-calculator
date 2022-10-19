package calculator.view.util.regex;

import java.util.regex.Pattern;

public class RegexMenuInput implements RegexUtil {

    private final Pattern REGEX_MENU_INPUT = Pattern.compile("[0-9]+[0-9]");

    @Override
    public boolean isPossible(String value) {
        return REGEX_MENU_INPUT.matcher(value).find();
    }
}
