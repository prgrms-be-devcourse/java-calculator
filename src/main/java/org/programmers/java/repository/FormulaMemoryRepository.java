package org.programmers.java.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormulaMemoryRepository implements FormulaRepository {
    Map<Long, String> formulaMap = new HashMap<>();
    private Long num = 0L;

    @Override
    public void save(String formula, String caculateValue) {
        StringBuilder stringBuilder = new StringBuilder(formula);
        stringBuilder.append(" = ");
        stringBuilder.append(caculateValue);
        formulaMap.put(num++, stringBuilder.toString());
    }

    @Override
    public Map<Long, String> getFormulaList() {
        return formulaMap;
    }
}
