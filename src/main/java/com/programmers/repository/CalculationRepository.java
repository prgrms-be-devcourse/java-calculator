package com.programmers.repository;

import com.programmers.core.data.CalculationResult;

import java.util.List;

public interface CalculationRepository {
    void save(CalculationResult result);

    List<CalculationResult> findAll();

}
