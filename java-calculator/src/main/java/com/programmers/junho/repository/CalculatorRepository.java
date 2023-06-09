package com.programmers.junho.repository;

import java.util.List;

public interface CalculatorRepository {
    void save(String calculatedResult);

    List<String> findAll();
}
