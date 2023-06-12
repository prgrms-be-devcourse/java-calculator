package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.entity.History;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository {

    private static final Map<Long, History> store = new LinkedHashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(History history) {
        history.setId(++sequence);
        store.put(history.getId(), history);
    }

    @Override
    public List<History> findAll() {
        return new ArrayList<>(store.values());
    }
}
