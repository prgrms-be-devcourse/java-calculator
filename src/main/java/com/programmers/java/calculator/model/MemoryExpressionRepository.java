package com.programmers.java.calculator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryExpressionRepository implements ExpressionRepository{

    private final Map<String, String> cache = new HashMap<>();
    private final List<String> memory = new ArrayList<>();

    @Override
    public boolean save(String expression, String result) {
        try {
            cache.put(expression, result);
            memory.add(expression + " = " + result);
            return true;
        } catch (RuntimeException r) {
            return false;
        }
    }

    @Override
    public List<String> findAll() {
        return memory;
    }

    @Override
    public String findById(String id) {
        return id + " = " + cache.get(id);
    }

    public boolean cached(String expression) {
        return cache.containsKey(expression);
    }

    @Override
    public void clear() {
        cache.clear();
        memory.clear();
    }
}
