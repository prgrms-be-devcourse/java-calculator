package com.programmers.repository;

import com.programmers.model.CalculationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCalculationRepository implements CalculationRepository {
    private static final Map<Long, CalculationResult> repository = new HashMap<>();
    private static long id = 0L;

    @Override
    public void save(CalculationResult result) {
        repository.put(++id, result);
    }

    @Override
    public List<CalculationResult> findAll() {
        return new ArrayList<>(repository.values());
    }

}
