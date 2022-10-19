package com.programmers.calculator.engine;

import java.util.HashMap;
import java.util.Map;

public class Operator {
    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            put("*", 3);
            put("/", 3);
            put("+", 2);
            put("-", 2);
            put("(", 1);
        }
    };

    // 연산자 우선순위
    public static int getPriority(String symbol) {
        return priority.get(symbol);
    }

    // 연산자 인지
    public static boolean isOperator(String symbol) {
        boolean ret = false;

        if(symbol.equals("+") || symbol.equals("-") ||
                symbol.equals("*") || symbol.equals("/")) {
            ret = true;
        }

        return ret;
    }
}
