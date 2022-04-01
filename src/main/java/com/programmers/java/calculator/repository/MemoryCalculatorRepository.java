package com.programmers.java.calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryCalculatorRepository implements CalculatorRepository{

    private final List<String> database = new ArrayList<>();

    @Override
    public void save(String result) {
        database.add(result);
    }

    @Override
    public void clear() {
        database.clear();
    }

    @Override
    public List<String> findAll() {
        return database;
    }
}
