package org.programmers.java.calculator.repository.impl;

import org.programmers.java.calculator.repository.CalculatorRepository;

import java.util.*;

public class CalculatorRepositoryImpl implements CalculatorRepository<String> {

    private final HashMap<String, String> cache = new HashMap<>();
    private final ArrayList<String> memory = new ArrayList<>();
    private Long id = 0L;

    public ArrayList<String> findAll() {
        return memory;
    }

    @Override
    public Long save(String input, String answer) {
        memory.add(id + ". " + input + " = " + answer);
        cache.put(input, answer);
        return id++;
    }

    @Override
    public Optional<String> find(String input) {
        return Optional.ofNullable(cache.get(input));
    }
}
