package com.calculator.java.domain.database;

import java.util.Set;
import java.util.TreeSet;

public class Database {
    private final Set<String> records;

    public Database() {
        records = new TreeSet<>();
    }

    public void add(String record) {
        records.add(record);
    }


    public String get() {
        StringBuilder sb = new StringBuilder();

        for(String record : records) {
            sb.append(record).append("\n");
        }

        return sb.toString();
    }
}
