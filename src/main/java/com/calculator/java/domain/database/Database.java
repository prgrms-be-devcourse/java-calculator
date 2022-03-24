package com.calculator.java.domain.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private final List<String> records = new ArrayList<>();

    public void add(String record) {
        records.add(record);
    }

    public List<String> get() {
        return records.stream().collect(Collectors.toList());
    }
}
