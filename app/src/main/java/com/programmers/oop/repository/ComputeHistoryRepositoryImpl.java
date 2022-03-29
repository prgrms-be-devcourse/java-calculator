package com.programmers.oop.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ComputeHistoryRepositoryImpl implements ComputeHistoryRepository<String> {

    static long count = 1;
    static final Map<Long, String> stoages = new TreeMap<>();


    @Override
    public String save(String calculation) {
        return stoages.put(count++, calculation);
    }

    @Override
    public List<String> findAll() {
        return stoages.entrySet().stream().map(Entry::getValue).toList();
    }
}
