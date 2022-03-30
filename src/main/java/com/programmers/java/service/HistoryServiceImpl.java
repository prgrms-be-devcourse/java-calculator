package com.programmers.java.service;

import com.programmers.java.entity.Calculation;
import com.programmers.java.repository.Repository;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {

    private final Repository repository;

    public HistoryServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(String formula, int result) {
        Calculation calculation = new Calculation(formula, result);
        repository.save(calculation);
    }

    public List<Calculation> findHistory() {
        return repository.findAll();
    }
}
