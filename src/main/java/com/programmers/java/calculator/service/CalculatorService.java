package com.programmers.java.calculator.service;

import com.programmers.java.calculator.domain.CalculationHistory;
import com.programmers.java.calculator.domain.calculator.Calculator;
import com.programmers.java.calculator.repository.CalculatorRepository;
import com.programmers.java.calculator.util.Converter;

import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    private final Converter<String, Deque<String>> converter;
    private final Calculator<Deque<String>, String> calculator;
    private final CalculatorRepository calculatorRepository;
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("\"^[-+*/()\\\\d\\\\s]+$\";");

    public CalculatorService(Converter<String, Deque<String>> converter, Calculator<Deque<String>, String> calculator, CalculatorRepository calculatorRepository) {
        this.converter = converter;
        this.calculator = calculator;
        this.calculatorRepository = calculatorRepository;
    }

    public String calculate(String expression) {
        validate(expression);
        Deque<String> postfixExpression = converter.convert(expression);
        String result = calculator.calculate(postfixExpression);
        calculatorRepository.save(expression, result);
        return result;
    }

    public void validate(Object expression) {
        if (EXPRESSION_PATTERN.matcher(expression.toString()).matches()) {
            throw new IllegalArgumentException("계산할 수 없는 식입니다.");
        }
    }

    public List<CalculationHistory> getHistoryList() {
        return calculatorRepository.findAll();
    }
}
