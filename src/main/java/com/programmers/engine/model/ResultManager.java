package com.programmers.engine.model;

import java.util.HashMap;
import java.util.Map;

public class ResultManager {
    private final Map<Integer, String> results = new HashMap<>();

    public void save(String expression, int answer) {
        results.put(results.size() + 1, expression + " = " + String.valueOf(answer));
    }

    public Map<Integer, String> readAllResults() {
        return results;
    }
}
