package org.programmers.java.calculator.repository.impl;

import org.programmers.java.calculator.repository.CalculatorRepository;

import java.util.*;

public class CalculatorRepositoryImpl implements CalculatorRepository<String, String> {

    private final LinkedHashMap<String, String> memory = new LinkedHashMap<>();

    public LinkedHashMap<String, String> findAll() {
        return memory;
    }

    @Override
    public void save(String input, String answer) {
        memory.put(input, answer);
    }

    @Override
    public Optional<String> find(String input) {
        return Optional.ofNullable(memory.get(input));
    }
}
