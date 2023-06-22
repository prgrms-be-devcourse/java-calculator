package org.programmers.repository;

import java.util.HashMap;
import java.util.Map;

public class CalRepositoryImpl implements CalRepository {

    Map<Long, CalculateResult> queryMap = new HashMap<>();
    private Long num = 0L;

    @Override
    public void save(String formula, String result) {
        CalculateResult calculateResult = new CalculateResult(formula, result);
        queryMap.put(num++, calculateResult);
    }

    @Override
    public Map<Long, String> getQueryList() {
        Map<Long, String> resultMap = new HashMap<>();
        for (Map.Entry<Long, CalculateResult> entry : queryMap.entrySet()) {
            Long key = entry.getKey();
            CalculateResult value = entry.getValue();
            resultMap.put(key, value.toString());
        }
        return resultMap;
    }

    private static class CalculateResult {
        private final String formula;
        private final String result;

        public CalculateResult(String formula, String result) {
            this.formula = formula;
            this.result = result;
        }

        @Override
        public String toString() {
            return formula + " = " + result;
        }
    }
}