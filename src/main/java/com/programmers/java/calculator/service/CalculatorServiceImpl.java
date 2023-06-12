package com.programmers.java.calculator.service;

import com.programmers.java.calculator.converter.Converter;
import com.programmers.java.calculator.entity.History;
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
        calculatorRepository.save(makeHistory(expression, result));
        return result;
    }

    @Override
    public List<History> getHistoryList() {
        return calculatorRepository.findAll();
    }

    private static History makeHistory(String expression, String result) {
        return new History(expression + " = " + result);
    }
}
