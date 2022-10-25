package org.programmers.java.calculator.repository.impl;

import org.programmers.java.calculator.repository.CalculatorRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorRepositoryImpl implements CalculatorRepository<String, String> {

    private final List<String> memory = new ArrayList<>();


    public List<String> findAll() {
        return memory;
    }

    @Override
    public void save() {

    }
}
