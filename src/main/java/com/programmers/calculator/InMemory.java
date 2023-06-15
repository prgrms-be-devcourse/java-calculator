package com.programmers.calculator;

import java.util.LinkedHashMap;
import java.util.Map;

public class InMemory implements Repository {
    private long id;
    private final Map<Long, CalcResult> resultMapList = new LinkedHashMap<>();

    @Override
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        resultMapList.values().forEach((value) -> {
            builder.append(value.toString()).append("\n");
        });
        return builder.toString().trim();
    }

    @Override
    public Long save(CalcResult calcResult) {
        resultMapList.put(id++, calcResult);
        return id;
    }

    @Override
    public int getSize() {
        return resultMapList.size();
    }
}
