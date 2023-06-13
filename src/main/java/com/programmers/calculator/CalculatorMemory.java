package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorMemory {
    private static final Map<Long, CalculationResult> store = new HashMap<>();
    private static long sequence = 0L;

    public void save(CalculationResult calculationResult) {
        store.put(++sequence, calculationResult);
    }

    public List<CalculationResult> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
