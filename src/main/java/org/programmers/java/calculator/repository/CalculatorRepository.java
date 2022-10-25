package org.programmers.java.calculator.repository;


import java.util.List;

public interface CalculatorRepository<K, V> {
    List<String> findAll();

    void save();
}
