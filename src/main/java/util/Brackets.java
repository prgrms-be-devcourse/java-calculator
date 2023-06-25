package util;

import java.util.HashMap;
import java.util.Map;

public class Brackets {
    public static final Map<String, String> openBrackets = new HashMap<>(){{put("(", ")");}};
    public static final Map<String, String> closeBrackets = new HashMap<>() {{put(")", "(");}};

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
