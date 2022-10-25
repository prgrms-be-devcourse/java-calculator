package org.programmers.java.calculator.service;


import java.util.Optional;

public interface CalculatorService {
    String record();

    Optional<String> find(String input);

    void save(String input, String answer);

}
