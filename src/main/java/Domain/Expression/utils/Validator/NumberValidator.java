package Domain.Expression.utils.Validator;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean validate(String s) {
        return NUMBER_PATTERN.matcher(s).matches();
    }
}
