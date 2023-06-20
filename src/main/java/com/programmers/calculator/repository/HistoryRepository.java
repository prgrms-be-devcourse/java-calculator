package com.programmers.calculator.repository;

import java.util.List;

public interface HistoryRepository {
    void save(CalculationHistory calculationHistory);
    List<CalculationHistory> findAll();
}
