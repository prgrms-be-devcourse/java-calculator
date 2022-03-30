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
        return ((previousKey==null) || (store.get(previousKey)==null)) ?
         "이전 계산 결과가 없습니다." : "이전 계산입니다: " + previousKey + " = " + store.get(previousKey);
    }

    @Override
    public String findByKey(String expression) {
        String foundResult = store.get(expression);
        return (foundResult==null)? "검색 결과가 없습니다" : foundResult;
    }

    @Override
    public List<String> printAll() {
        StringBuilder sb = new StringBuilder();
        int sequence = 0;

        List<String> result = new ArrayList<>();

        Set<String> keys = store.keySet();

        if (keys.isEmpty()) {
            result.add("이전 계산 결과가 없습니다.");
            return result;
        }

        for (String key : keys) {
            result.add(
                    sb.append(++sequence).append(": ").append(key)
                            .append(" = ").append(store.get(key)).toString());
            sb.setLength(0);
        }

        return result;
    }
}
