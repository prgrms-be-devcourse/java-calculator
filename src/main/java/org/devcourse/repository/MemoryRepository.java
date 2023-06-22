package org.devcourse.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements Repository {

    private final Map<Integer, String> runHistoryMap;

    public MemoryRepository() {
        runHistoryMap = new HashMap<>();
    }

    @Override
    public String findLatestHistory() {
        return runHistoryMap.get(runHistoryMap.size());
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(runHistoryMap.values());
    }


    @Override
    public void save(String runHistory) {
        runHistoryMap.put(runHistoryMap.size() + 1, runHistory);
    }

}

