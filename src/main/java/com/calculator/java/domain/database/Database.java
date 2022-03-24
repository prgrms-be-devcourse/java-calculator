package com.calculator.java.domain.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Database {
    private final List<String> records;

    public Database() {
        records = new ArrayList<>();
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
