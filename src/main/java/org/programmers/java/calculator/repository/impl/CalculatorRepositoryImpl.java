package org.programmers.java.calculator.repository.impl;

import org.programmers.java.calculator.repository.CalculatorRepository;

import java.util.*;

public class CalculatorRepositoryImpl implements CalculatorRepository<String, String> {

    private final HashMap<String, String> cache = new HashMap<>();
    private final ArrayList<String> memory = new ArrayList<>();

    public ArrayList<String> findAll() {
        return memory;
    }

    @Override
    public void save(String input, String answer) {
        memory.add(input + " = " + answer);
        cache.put(input, answer);
    }

    @Override
    public Optional<String> find(String input) {
        return Optional.ofNullable(cache.get(input));
    }
}
