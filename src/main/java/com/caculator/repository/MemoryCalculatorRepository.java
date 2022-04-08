package com.caculator.repository;

import com.caculator.dto.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository{

    private static final Map<Long, Result> store = new HashMap<>();
    private static long id = 0L;

    @Override
    public void save(Result result) {
        store.put(++id, result);
    }

    @Override
    public List<Result> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
