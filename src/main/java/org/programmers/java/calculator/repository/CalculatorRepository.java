package org.programmers.java.calculator.repository;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;

public interface CalculatorRepository<K, V> {
    ArrayList<String> findAll();

    void save(String input, String  answer);

    Optional<String> find(String input);
}
