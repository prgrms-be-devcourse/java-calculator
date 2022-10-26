package org.programmers.java.calculator.service.impl;


import org.programmers.java.calculator.repository.CalculatorRepository;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;

import java.util.Optional;

public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();

    public String calculationResult() {
        StringBuilder sb = new StringBuilder();
        calculatorRepository.findAll().forEach(find -> {
            sb.append(find);
            sb.append("\n");
        });
        return sb.toString();
    }

    public Optional<String> find(String input) {
        return calculatorRepository.find(input);
    }

    @Override
    public void save(String input, String answer) {
        calculatorRepository.save(input, answer);
    }
}
