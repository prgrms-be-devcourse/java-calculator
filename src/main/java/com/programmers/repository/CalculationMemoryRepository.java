package com.programmers.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationMemoryRepository implements CalculationRepository {
   private final Map<Integer, String> calculations = new HashMap<>();

    @Override
    public void save(String calculation) {
        int nextId = calculations.size() + 1;

        calculations.put(nextId, calculation);
    }

    @Override
    public List<String> findAll() {
        return calculations.keySet()
                .stream()
                .sorted()
                .map(id -> calculations.get(id))
                .toList();
    }
}
