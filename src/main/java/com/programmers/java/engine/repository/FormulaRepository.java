package com.programmers.java.engine.repository;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class FormulaRepository implements MemoryRepository {

    private final Map<String, Long> history = new HashMap<>();

    @Override
    public void save(String formula, Long result) {
        history.put(formula, result);
    }

    @Override
    public void inquire() {
        history.forEach((form, result) -> System.out.println(form + " = " + result));
        System.out.println("END !");
    }

    @Override
    public int size() {
        return history.size();
    }
}
