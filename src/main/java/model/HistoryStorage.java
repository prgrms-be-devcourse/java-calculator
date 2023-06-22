package model;

import util.CalculatorUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class HistoryStorage {
    private static final String STORAGE_EMPTY_MESSAGE = "연산 기록이 없습니다.";
    private final Map<Integer, String> storage;
    private int id = 0;

    public HistoryStorage() {
        this.storage = new LinkedHashMap<>();
    }

    public void save(String expression, String result) {
        storage.put(id, expression + " = " + result);
        id++;
    }

    public String loadAll() {
        if (storage.isEmpty()) {
            return STORAGE_EMPTY_MESSAGE;
        }

        return String.join("\n", storage.values());
    }
}
