package com.waterfogsw.repository;

import com.waterfogsw.domain.Calculation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculationRepository implements CalculationRepository {
    private final Map<Long, Calculation> store = new LinkedHashMap<>();

    @Override
    public synchronized void save(String formula, String result) {
        Calculation calculation = new Calculation(formula, result);
        Long nextIdx = getNextIdx() + 1;
        store.put(nextIdx, calculation);
    }

    @Override
    public Calculation findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Calculation> findAll() {
        return new ArrayList<>(store.values());
    }

    private Long getNextIdx() {
        return store.keySet().stream().max(Long::compareTo).orElse(-1L);
    }
}
