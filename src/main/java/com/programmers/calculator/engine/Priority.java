package com.programmers.calculator.engine;

import java.util.HashMap;
import java.util.Map;

class Priority {
    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            put("*", 3);
            put("/", 3);
            put("+", 2);
            put("-", 2);
            put("(", 1);
        }
    };

    public static int getPriority(String symbol) {
        return priority.get(symbol);
    }
}
