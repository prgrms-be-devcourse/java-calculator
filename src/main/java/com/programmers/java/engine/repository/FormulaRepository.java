package com.programmers.java.engine.repository;

import lombok.Getter;

import java.util.LinkedHashMap;

@Getter
public class FormulaRepository implements MemoryRepository {

    private final LinkedHashMap<String, Long> history = new LinkedHashMap<>();

    @Override
    public void save(String formula, Long result) {
        history.put(formula, result);
    }

    @Override
    public void findAll() {
        history.forEach((form, result) -> System.out.println(form + " = " + result));
    }

    @Override
    public int size() {
        return history.size();
    }
}
