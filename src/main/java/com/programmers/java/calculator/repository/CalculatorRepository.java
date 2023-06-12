package com.programmers.java.calculator.repository;

import com.programmers.java.calculator.entity.History;

public interface CalculatorRepository {

    void save(History history);
}
