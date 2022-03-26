package com.waterfogsw.repository;

import com.waterfogsw.domain.Calculation;

import java.util.List;

public interface CalculationRepository {
    void save(Calculation calculation);

    Calculation findById(Long id);

    List<Calculation> findAll();
}
