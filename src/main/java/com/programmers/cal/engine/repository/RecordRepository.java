package com.programmers.cal.engine.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecordRepository implements Repository {

    private static final Map<String, String> map = new LinkedHashMap<>();

    @Override
    public void save(String inputString, String result) {
        map.put(inputString, result);
    }

    @Override
    public List<String> findAll() {
        List<String> recordList = new ArrayList<>();

        map.forEach((key, value) -> {
            recordList.add(key + "=" + value);
        });

        return recordList;
    }
}
