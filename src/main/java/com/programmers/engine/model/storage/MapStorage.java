package com.programmers.engine.model.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage implements Storage {

    private Map<Integer, String> mapStorage;
    private int id;

    public MapStorage() {
        this.mapStorage = new HashMap<>();
    }

    @Override
    public List<String> findAll() {
        return mapStorage.keySet()
                .stream()
                .sorted()
                .map(id -> mapStorage.get(id))
                .toList();
    }

    @Override
    public void save(String calculationCommand, Integer calculationResult) {
        StringBuilder calculationResultBuilder = new StringBuilder();
        String result = calculationResultBuilder
                .append(calculationCommand)
                .append(" = ")
                .append(calculationResult)
                .toString();
        mapStorage.put(id++, result);
    }
}
