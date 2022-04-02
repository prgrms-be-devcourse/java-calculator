package com.calculator.java.database;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private final Map<String, String> records = new LinkedHashMap<>();

    public void add(String expression, String result) {
        records.put(expression, result);
    }

    public List<String> get() {
        return records.keySet().stream()
                .map(expression -> expression+" = "+records.get(expression))
                .collect(Collectors.toList());
    }
}
