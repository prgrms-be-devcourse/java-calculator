package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class MemoryCalculationRepository implements Repository {
    private final List<String> repository = new ArrayList<>();

    @Override
    public void save(String expression, String result) {
        repository.add(expression + " = " + result);
    }

    @Override
    public List<String> findAll() {
        return repository;
    }
}
