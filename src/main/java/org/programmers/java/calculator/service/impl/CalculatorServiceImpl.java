package org.programmers.java.calculator.service.impl;


import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.repository.CalculatorRepository;
import org.programmers.java.calculator.service.CalculatorService;

import java.util.Optional;

@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public String record() {
        StringBuffer sb = new StringBuffer();
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
