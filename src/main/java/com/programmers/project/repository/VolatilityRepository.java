package com.programmers.project.repository;

import java.util.ArrayList;
import java.util.List;

public class VolatilityRepository implements DataRepository{
    List<String> records = new ArrayList<>();

    @Override
    public List<String> getAllRecords() {
        return records;
    }

    @Override
    public void add(String str) {
        records.add(str);
    }
}
