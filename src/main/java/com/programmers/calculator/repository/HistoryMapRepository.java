package com.programmers.calculator.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryMapRepository implements HistoryRepository {

    private static Map<Long, CalculationHistory> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(CalculationHistory calculationHistory) {
        calculationHistory.setId(++sequence);
        store.put(calculationHistory.getId(), calculationHistory);
    }

    @Override
    public List<CalculationHistory> findAll() {
        return new ArrayList<>(store.values());
    }
}
