package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryStorage {
    private final Map<Integer, String> storage;
    private int id = 0;

    public HistoryStorage() {
        this.storage = new LinkedHashMap<>();
    }

    public void save(String expression, String result) {
        storage.put(id++, expression + " = " + result);
    }

    public String loadAll() {
        return String.join("\n", storage.values());
    }
}
