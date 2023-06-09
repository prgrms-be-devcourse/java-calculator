package com.programmers.junho.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCalculatorRepository implements CalculatorRepository {

    private final List<String> calculatedData;

    public ListCalculatorRepository() {
        this.calculatedData = new ArrayList<>();
    }

    @Override
    public void save(String calculatedResult) {
        calculatedData.add(calculatedResult);
    }

    @Override
    public List<String> findAll() {
        return Collections.unmodifiableList(calculatedData);
    }
}
