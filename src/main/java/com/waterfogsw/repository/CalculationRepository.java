package com.waterfogsw.repository;

import com.waterfogsw.domain.Calculation;

import java.util.List;

public interface CalculationRepository {

    void save(String formula, String result);

    Calculation findById(Long id);

    List<Calculation> findAll();
}
