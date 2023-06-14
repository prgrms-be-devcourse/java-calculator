package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.entity.CalculationHistory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository {

    private static final Map<Long, CalculationHistory> store = new LinkedHashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(String expression, String result) {
        sequence++;
        store.put(sequence, CalculationHistory.of(sequence,
                expression,
                result));
    }

    @Override
    public List<CalculationHistory> findAll() {
        return new ArrayList<>(store.values());
    }
}
