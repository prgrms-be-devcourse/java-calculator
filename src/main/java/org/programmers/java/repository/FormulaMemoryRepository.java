package org.programmers.java.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FormulaMemoryRepository implements FormulaRepository {
    private final Map<Long, String> formulaMap = new LinkedHashMap<>();
    private Long num = 0L;

    @Override
    public String save(String formula, String caculateValue) {
        StringBuilder stringBuilder = new StringBuilder(formula);
        stringBuilder.append(" = ");
        stringBuilder.append(caculateValue);
        formulaMap.put(num++, stringBuilder.toString());
        return formulaMap.get(num-1);
    }

    @Override
    public Map<Long, String> getFormulaList() {
        return new LinkedHashMap<>(formulaMap);
    }
}
