package com.programmers.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorRepository implements Repository {

    private final Map<Long, String> records = new HashMap<>();
    private Long key = 0L;

    @Override
    public void save(String expression) {
        records.put(++key, expression);
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(records.values());
    }
}