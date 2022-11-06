package com.programmers.java.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryMapRepository implements Repository {

    private final Map<String, Double> map = new HashMap<>();

    @Override
    public void save(String expression, double result) {
        map.put(expression, result);
    }

    @Override
    public Map<String, Double> findAll() {
        return this.map;
    }

    @Override
    public Optional<Double> findOne(String expression) {
        return Optional.ofNullable(map.get(expression));
    }
}
