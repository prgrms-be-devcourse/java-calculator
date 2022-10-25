package org.programmers.java.calculator.repository.impl;

import org.programmers.java.calculator.repository.CalculatorRepository;

import java.util.*;
import java.util.stream.IntStream;

public class CalculatorRepositoryImpl implements CalculatorRepository<String, String> {

    private final List<String> memory = new ArrayList<>();
    private final Map<String, String> cache = new HashMap<>();


    public List<String> findAll() {
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
