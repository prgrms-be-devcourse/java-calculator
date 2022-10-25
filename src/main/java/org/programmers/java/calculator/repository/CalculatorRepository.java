package org.programmers.java.calculator.repository;


import java.util.List;
import java.util.Optional;

public interface CalculatorRepository<K, V> {
    List<String> findAll();

    void save(String input, String  answer);

    Optional<String> find(String input);
}
