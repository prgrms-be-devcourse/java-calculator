package com.programmers.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class InMemory implements Repository {
    private long id;
    private final Map<Long, CalcResult> inMemory = new LinkedHashMap<>();

    @Override
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        inMemory.values().forEach((value) -> {
            builder.append(value.toString()).append("\n");
        });
        return builder.toString().trim();
    }

    @Override
    public void save(CalcResult calcResult) {
        inMemory.put(id++, calcResult);
    }

    @Override
    public int getSize() {
        return inMemory.size();
    }
}
