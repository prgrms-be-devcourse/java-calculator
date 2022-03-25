package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;

import java.util.List;
import java.util.Optional;

public interface CalculationRepository {

    Optional<Long> save(Calculation calculation);

    List<Calculation> findAll();

    int clear();
}
