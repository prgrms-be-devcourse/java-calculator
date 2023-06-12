package org.programmers.repository;

import java.util.HashMap;
import java.util.Map;


public class CalRepositoryImpl implements CalRepository{

    Map<Long, String> queryMap = new HashMap<>();
    private Long num = 0L;

    @Override
    public void save(String formula, String result) {
        StringBuilder stringBuilder = new StringBuilder(formula);
        stringBuilder.append(" = ");
        stringBuilder.append(result);
        queryMap.put(num++, stringBuilder.toString());

    }

    @Override
    public Map<Long, String> getQueryList() {
        return queryMap;
    }
}
