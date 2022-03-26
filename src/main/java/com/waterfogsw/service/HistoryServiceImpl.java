package com.waterfogsw.service;

import com.waterfogsw.domain.Calculation;
import com.waterfogsw.repository.CalculationRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final CalculationRepository repository;

    private static Long calIdx = 0L;

    @Override
    public void save(String expr, String result) {
        Calculation calculation = new Calculation(calIdx, expr, result);
        repository.save(calculation);
        incrIdx();
    }

    @Override
    public List<Calculation> findAll() {
        return repository.findAll();
    }

    private void incrIdx() {
        calIdx++;
    }
}
