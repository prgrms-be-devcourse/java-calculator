package com.waterfogsw.service;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.repository.CalculationRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final CalculationRepository repository;

    @Override
    public void save(String formula, String result) {
        repository.save(formula, result);
    }

    @Override
    public List<Calculation> findAll() {
        return repository.findAll();
    }
}
