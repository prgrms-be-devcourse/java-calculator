package com.calculator.java.database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<String> records = new ArrayList<>();

    public void add(String record) {
        records.add(record);
    }

    public List<String> get() {
        return new ArrayList<>(records);
    }
}
