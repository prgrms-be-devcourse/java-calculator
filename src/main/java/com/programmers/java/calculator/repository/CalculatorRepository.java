package com.programmers.java.calculator.repository;

import java.util.List;

public interface CalculatorRepository {
    void save(String result);
    void clear();
    List<String> findAll();
}
