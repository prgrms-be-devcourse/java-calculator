package com.devcourse.engine.historian;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Historian {

    private HashMap<Integer, String> history = new HashMap<>();
    private static int lastIndex = 1;

    public void saveHistory(List<String> expression, double result) {
        history.put(lastIndex ++, String.join(" ", expression) + " = " + result);
    }

    public String getHistory() {
        return history.keySet().stream()
                .map(idx -> idx + " -> " + history.get(idx) + "\n")
                .collect(Collectors.joining());
    }
}
