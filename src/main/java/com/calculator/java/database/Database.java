package com.calculator.java.database;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private static Database database;
    private final Map<String, String> records = new LinkedHashMap<>();

    private Database() {}

    public void add(String expression, String result) {
        records.put(expression, result);
    }

    public List<String> get() {
        return records.keySet().stream()
                .map(expression -> expression+" = "+records.get(expression))
                .collect(Collectors.toList());
    }

    public static Database getInstance() {
        if(database == null) {
            synchronized (Database.class) {
                if(database == null) {
                    database = new Database();
                }
            }
        }
        return database;
    }
}
