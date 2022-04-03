package com.programmers.calculator.engine.repository;

import java.util.List;

public interface CalculatorRepository {
    long save (String history);
    String findOne(long sequence);
    List<String> findAll();
}
