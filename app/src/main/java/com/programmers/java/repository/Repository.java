package com.programmers.java.repository;

import java.util.Map;
import java.util.Optional;

public interface Repository {
    void save(String expression, double result);

    Map<String, Double> findAll();

    Optional<Double> findOne(String expression);
}
