package com.programmers.calculator.repository;

import com.programmers.calculator.domain.CalculateHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository implements Repository<Long, CalculateHistory> {

    private final Map<Long, CalculateHistory> database = new HashMap<>();

    @Override
    public CalculateHistory save(CalculateHistory entity) {
        database.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<CalculateHistory> findAll() {
        return new ArrayList<>(database.values());
    }

}