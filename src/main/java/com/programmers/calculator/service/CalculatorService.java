package com.programmers.calculator.service;

import com.programmers.calculator.repository.Repository;

public class CalculatorService {

    private final Repository repository;

    public CalculatorService(Repository repository) {
        this.repository = repository;
    }

}
