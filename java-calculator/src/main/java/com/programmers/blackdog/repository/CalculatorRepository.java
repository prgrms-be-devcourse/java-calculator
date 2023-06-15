package com.programmers.blackdog.repository;

import java.util.List;

public interface CalculatorRepository {
    void save(String calculatedResult);
    List<String> findAll();
}
