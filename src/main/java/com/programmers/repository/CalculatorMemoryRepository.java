package com.programmers.repository;

import com.programmers.domain.Calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorMemoryRepository {
    private final Map<Integer, Calculator> calculations = new HashMap<>();

    public void save(Calculator calculator) {
        int nextId = calculations.size() + 1;

        calculations.put(nextId, calculator);
    }

    public List<Calculator> findAll() {
        return calculations.keySet()
                .stream().sorted()
                .map(calculations::get)
                .toList();
    }
}
