package com.programmers.calculator.engine.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository{
    private Map<Long, String> results = new HashMap<>();
    private long sequence = 0L;

    public long save (String history) {
        results.put(++sequence, history);
        return sequence;
    }

    public String findOne(long sequence) {
        return results.get(sequence);
    }
    public List<String> findAll() {
        return new ArrayList<>(results.values());
    }
}
