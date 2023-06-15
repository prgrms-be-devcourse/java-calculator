package Domain.Expression.utils.Validator;

import java.util.regex.Pattern;

public class OperationValidator {
    private static final Pattern OPERATION_PATTERN = Pattern.compile("^[+\\-*\\/]$");

    public static boolean validate(String s) {
        return OPERATION_PATTERN.matcher(s).matches();
    }
}
