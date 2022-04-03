package calculator.engine.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private static Map<Character, Operator> map = null;

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
        Operator op = getOperatorMap().getOrDefault(sign, null);
        if (op == null)
            return false;
        return true;
    }

    public static Map<Character, Operator> getOperatorMap() {
        if (map == null) {
            map = new HashMap<>();
            Arrays.stream(Operator.values())
                    .forEach((op) -> {
                        map.put(op.getSign(), op);
                    });
        }
        return map;
    }

    public static double callExec(char sign, double a, double b) {
        Operator op = getOperatorMap().getOrDefault(sign, null);
        if (sign == Operator.DIVIDE.getSign() && b == 0)
            throw new RuntimeException("0으로 나눌 수 없습니다.");
        return op.exec(a, b);
    }
}
