package com.programmers.engine;

import com.programmers.engine.model.Storage;

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
        mapStorage.put(id++, calculationCommand + " = " + calculationResult);
    }
}
