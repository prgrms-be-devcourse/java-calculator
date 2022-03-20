package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;

import java.util.List;

public interface CalculationRepository {

    void save(Calculation calculation);

    List<Calculation> findAll();

    int clear();
}
