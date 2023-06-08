package com.devcourse.java.domain.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStorage implements Storage<CalculateResult> {
    private static final Map<Integer, CalculateResult> storage = new HashMap<>();
    private int id = 1;

    public MemoryStorage() { }

    @Override
    public void save(CalculateResult calculateResult) {
        storage.put(id, calculateResult);
        increaseId();
    }

    @Override
    public List<CalculateResult> fetchAll() {
        return new ArrayList<>(storage.values());
    }

    // for test
    public int getId() {
        return id;
    }

    private void increaseId() {
        this.id += 1;
    }
}
