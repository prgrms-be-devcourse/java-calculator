package me.kimihiqq.model;

import java.util.HashMap;
import java.util.Map;

public class History {
    private final Map<Integer, String> history = new HashMap<>();
    private int id = 0;

    public void add(String result) {
        history.put(id++, result);
    }

    public Map<Integer, String> getAll() {
        return history;
    }
}
