package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.entity.History;

import java.util.List;

public interface CalculatorRepository {

    void save(History history);

    List<History> findAll();
}
