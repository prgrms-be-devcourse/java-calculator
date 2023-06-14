package com.programmers.java.calculator.service;

import com.programmers.java.calculator.converter.Converter;
import com.programmers.java.calculator.entity.CalculationHistory;
import com.programmers.java.calculator.repository.CalculatorRepository;

import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private final Converter converter;
    private final CalculatorRepository calculatorRepository;

    public CalculatorServiceImpl(Converter converter, CalculatorRepository calculatorRepository) {
        this.converter = converter;
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public String calculate(String expression) {
        String result = (String) converter.convert(expression);
        calculatorRepository.save(expression, result);
        return result;
    }

    @Override
    public List<CalculationHistory> getHistoryList() {
        return calculatorRepository.findAll();
    }
}
