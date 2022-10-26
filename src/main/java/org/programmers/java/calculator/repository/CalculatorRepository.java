package org.programmers.java.calculator.repository;


import java.util.ArrayList;
import java.util.Optional;

public interface CalculatorRepository<String> {
    ArrayList<String> findAll();

    Long save(String input, String  answer);

    Optional<String> find(String input);
}
