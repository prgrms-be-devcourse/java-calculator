package com.programmers.calculator;

import java.util.HashMap;
import java.util.Map;

interface Priority {
    static Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            put("*", 3);
            put("/", 3);
            put("+", 2);
            put("-", 2);
            put("(", 1);
        }
    };

    static int getPriority(String symbol) {
        return priority.get(symbol);
    }
}
