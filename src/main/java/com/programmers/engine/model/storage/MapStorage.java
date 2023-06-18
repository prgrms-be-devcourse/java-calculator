package com.programmers.engine.model.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage implements Storage {

    private Map<Integer, List<String>> mapStorage;
    private int id;

    public MapStorage() {
        this.mapStorage = new HashMap<>();
    }

    @Override
    public List<List<String>> findAll() {
        return mapStorage.keySet()
                .stream()
                .sorted()
                .map(id -> mapStorage.get(id))
                .toList();
    }

    @Override
    public void save(String calculationCommand, Integer calculationResult) {
        List<String> result = new ArrayList<>();
        result.add(calculationCommand);
        result.add(calculationResult + "");
        mapStorage.put(id++, result);
    }
}
