package com.programmers.repository;

import com.programmers.domain.model.Calculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculationMemoryRepository implements CalculationRepository {
   private final Map<Integer, Calculation> calculations = new HashMap<>();

    @Override
    public void save(Calculation calculation) {
        int nextId = calculations.size() + 1;

        calculations.put(nextId, calculation);
    }

    @Override
    public List<Calculation> findAll() {
        return calculations.keySet()
                .stream().sorted()
                .map(calculations::get)
                .toList();
    }
}
