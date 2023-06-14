package com.programmers.repository;

import com.programmers.domain.Calculator;

import java.util.List;

public interface CalculatorRepository {

    void save(Calculator calculation);

    List<Calculator> findAll();
}
