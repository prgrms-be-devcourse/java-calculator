package com.programmers.calculator.engine.storage;

import java.util.HashMap;
import java.util.Map;

public class LocalMemoryStorage implements Storage {
    private final Map<Integer, String> calculationResult = new HashMap<>();
    private int mapIndex = 1;

    @Override
    public void save(String result) {
        calculationResult.put(mapIndex++, result);
    }

    @Override
    public Map<Integer, String> findAll() {
        return calculationResult;
    }
}
