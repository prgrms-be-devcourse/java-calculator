package calculator.engine.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Util {

    private static Map<Character, Integer> map = null;

    public static boolean isNumberWithWhite(char c) {
        if (isNumber(c))
            return true;
        else if (Character.isWhitespace(c))
            return true;
        return false;
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static boolean isOperator(char sign) {
        int order = getOperatorMap().getOrDefault(sign, -1);
        if (order == -1)
            return false;
        return true;
    }

    public static Map<Character, Integer> getOperatorMap() {
        if (map == null) {
            map = new HashMap<>();
            Arrays.stream(Operator.values())
                    .forEach((op) -> {
                        map.put(op.getSign(), op.getOrder());
                    });
        }
        return map;
    }
}
