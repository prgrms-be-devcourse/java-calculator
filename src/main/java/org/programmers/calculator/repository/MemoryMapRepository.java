package org.programmers.calculator.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class MemoryMapRepository implements Repository {

    private static String previousKey;
    private static final LinkedHashMap<String, String> store = new LinkedHashMap<>();

    @Override
    public void save(String expression, String result) {
        previousKey = expression;
        store.put(expression,result);
    }

    @Override
    public String findPrevious() {
        StringBuilder sb = new StringBuilder();
        sb.append("이전 계산입니다: " + previousKey + " = " + store.get(previousKey));
        return sb.toString();
    }

    @Override
    public String findByKey(String expression) throws IllegalArgumentException {
        String foundCalculationResult = store.get(expression);
        if (foundCalculationResult==null) {
            throw new IllegalArgumentException();
        }
        return foundCalculationResult;
    }

    @Override
    public List<String> printAll() {
        StringBuilder sb = new StringBuilder();
        int sequence = 0;

        List<String> result = new ArrayList<>();

        Set<String> keys = store.keySet();

        for (String key : keys) {
            result.add(
                    sb.append(++sequence + ": " + key + " = " + store.get(key)).toString());
            sb.setLength(0);
        }

        return result;
    }
}
