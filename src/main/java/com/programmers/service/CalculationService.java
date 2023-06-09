package com.programmers.service;

import com.programmers.domain.Calculator;
import com.programmers.domain.Tokenizer;
import com.programmers.repository.CalculationRepository;

import java.util.List;

public class CalculationService {
    private final CalculationRepository calculationRepository;
    private final Tokenizer tokenizer;
    private final Calculator calculator;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
        this.tokenizer = new Tokenizer();
        this.calculator = new Calculator();
    }

    public int calculate(String input) {
        String[] tokenized = tokenizer.tokenize(input);
        int result = calculator.calculateInfixExpression(tokenized);

        saveCalculation(tokenized, result);

        return result;
    }

    private void saveCalculation(String[] tokenized, int result) {
        StringBuilder calculationBuilder = new StringBuilder();
        for (String str : tokenized) {
            calculationBuilder.append(str);
            calculationBuilder.append(" ");
        }
        calculationBuilder.append("= ");
        calculationBuilder.append(result);

        calculationRepository.save(calculationBuilder.toString());
    }

    public List<String> findCalculations() {
        return calculationRepository.findAll();
    }
}
