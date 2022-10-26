package org.programmers.java.calculator.service.impl;


import lombok.RequiredArgsConstructor;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;

import java.util.LinkedHashMap;
import java.util.Optional;

@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepositoryImpl calculatorRepositoryImpl;

    public String record() {
        StringBuffer sb = new StringBuffer();
        LinkedHashMap<String, String> findAll = calculatorRepositoryImpl.findAll();
        findAll.forEach((key, value) -> {
            sb.append(key);
            sb.append(" = ");
            sb.append(value);
            sb.append("\n");
        });
        return sb.toString();
    }

    public Optional<String> find(String input) {
        return calculatorRepositoryImpl.find(input);
    }

    @Override
    public void save(String input, String answer) {
        calculatorRepositoryImpl.save(input, answer);
    }
}
