package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Util {

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

    public static boolean isOperator(char c) {
        long count = Arrays.stream(Operator.values())
                .filter((op) -> op.getSign() == c)
                .count();
        return count == 0 ? false : true;
    }

    public static Map<Character, Integer> getOrderMap() {
        Map<Character, Integer> map = new HashMap<>();
        Arrays.stream(Operator.values())
                .forEach((op) -> {
                    map.put(op.getSign(), op.getOrder());
                });
        return map;
    }
}
