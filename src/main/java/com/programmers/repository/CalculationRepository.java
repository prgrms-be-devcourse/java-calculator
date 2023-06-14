package com.programmers.repository;

import com.programmers.domain.model.Calculation;

import java.util.List;

public interface CalculationRepository {

    void save(Calculation calculation);
    List<Calculation> findAll();
}
