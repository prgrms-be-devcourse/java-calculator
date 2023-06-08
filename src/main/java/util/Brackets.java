package util;

import java.util.HashMap;
import java.util.Map;

public class Brackets {
    public static final Map<String, String> openBrackets;
    public static final Map<String, String> closeBrackets;

    static {
        openBrackets = new HashMap<>();
        closeBrackets = new HashMap<>();
        openBrackets.put("(", ")");
        closeBrackets.put(")", "(");
    }

    public static boolean isOpenBrackets(String input) {
        return openBrackets.containsKey(input);
    }
    public static boolean isCloseBrackets(String input) {
        return closeBrackets.containsKey(input);
    }

    public static boolean isMatch(String peek, String input) {
        if (openBrackets.containsKey(input)) {
            return false;
        }

        return closeBrackets.get(input).equals(peek);
    }
}
