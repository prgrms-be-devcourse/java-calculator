package hyuk.util;

import java.util.regex.Pattern;

public class PatternValidator {

    public static final Pattern OperandPattern = Pattern.compile("^[0-9]*$");
    public static final Pattern OperatorPatter = Pattern.compile("[+\\-*/]");
}
