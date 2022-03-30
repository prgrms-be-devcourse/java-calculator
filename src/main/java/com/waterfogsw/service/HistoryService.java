package com.waterfogsw.service;

import com.waterfogsw.domain.Calculation;

import java.util.List;

public interface HistoryService {
    void save(String formula, String result);

    List<Calculation> findAll();
}
