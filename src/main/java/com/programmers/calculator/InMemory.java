package com.programmers.calculator;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemory implements Repository {
    private long id;
    private final Map<Long, CalcResult> resultMapList = new LinkedHashMap<>();

    @Override
    public Map<Long, CalcResult> findAll() {
        return Collections.unmodifiableMap(resultMapList);
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
