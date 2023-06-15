package org.programmers.java.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FormulaMemoryRepository implements FormulaRepository {
    private final Map<Long, String> formulaMap = new LinkedHashMap<>();
    private Long num = 0L;

    @Override
    public void save(String formulaAndResult) {
        formulaMap.put(num++, formulaAndResult);
    }

    @Override
    public Map<Long, String> getFormulaList() {
        return new LinkedHashMap<>(formulaMap);
    }
}
