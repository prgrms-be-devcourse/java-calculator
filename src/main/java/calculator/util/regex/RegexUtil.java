package calculator.util.regex;

import java.util.regex.Pattern;

public class RegexUtil {

    public static final Pattern REGEX_FORMULA_WORD = Pattern.compile("[0-9]|[+\\-*/]");

    public static boolean checkWrong(Pattern pattern, String value) {
        return !pattern.matcher(value).find();
    }
}
