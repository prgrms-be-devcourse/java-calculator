package com.programmers.engine.model;

import java.util.HashMap;
import java.util.Map;

public class ResultManager {
    private final Map<Integer, String> results = new HashMap<>();
    private int key = 0;

    public void save(String expression, int answer) {
        results.put(++key, expression + " = " + String.valueOf(answer));
    }

    public Map<Integer, String> readAllResults() {
        return results;
    }
}
