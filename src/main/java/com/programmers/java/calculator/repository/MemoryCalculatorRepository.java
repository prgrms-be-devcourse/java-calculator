package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.entity.History;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository {

    private static final Map<Long, History> store = new LinkedHashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(History history) {
        history.setId(++sequence);
        store.put(history.getId(), history);
    }
}
