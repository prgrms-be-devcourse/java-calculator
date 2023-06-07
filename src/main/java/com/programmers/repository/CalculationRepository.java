package com.programmers.repository;

import java.util.List;

public interface CalculationRepository {

    void save(String calculation);
    List<String> findAll();
}
