package com.waterfogsw.repository;

import com.waterfogsw.domain.Calculation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculationRepository implements CalculationRepository {
    private final Map<Long, Calculation> store = new LinkedHashMap<>();

    @Override
    public void save(Calculation calculation) {
        store.put(calculation.getId(), calculation);
    }

    @Override
    public Calculation findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Calculation> findAll() {
        return new ArrayList<>(store.values());
    }
}
