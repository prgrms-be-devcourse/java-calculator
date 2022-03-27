package com.caculator.repository;

import java.util.List;

public interface CalculatorRepository {
    void save(Result result);

    List<Result> findAll();

    void clear();
}
