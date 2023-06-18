package com.programmers.calculator.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryMapRepository implements HistoryRepository {

    private final Map<Long, CalculationHistory> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public void save(CalculationHistory calculationHistory) {
        calculationHistory.setId(++sequence);
        store.put(calculationHistory.getId(), calculationHistory.saveHistory());
    }

    @Override
    public List<CalculationHistory> findAll() {
        return new ArrayList<>(store.values());
    }
}
