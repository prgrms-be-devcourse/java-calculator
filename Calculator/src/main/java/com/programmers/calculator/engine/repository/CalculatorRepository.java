package com.programmers.calculator.engine.repository;

import java.util.List;

public interface CalculatorRepository {

    public long save (String history);
    public String findOne(long sequence);
    public List<String> findAll();
}
