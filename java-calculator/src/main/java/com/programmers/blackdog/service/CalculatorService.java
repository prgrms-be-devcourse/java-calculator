package com.programmers.blackdog.service;

import com.programmers.blackdog.domain.calculator.Calculator;
import com.programmers.blackdog.domain.expression.Expression;
import com.programmers.blackdog.domain.expression.InfixExpression;
import com.programmers.blackdog.domain.calculator.AbstractCalculator;
import com.programmers.blackdog.repository.CalculatorRepository;
import com.programmers.blackdog.repository.MemoryCalculatorRepository;

import java.util.List;

// 계산 및 저장 로직 담당
public class CalculatorService implements Service {
    private static final String EQUAL = " = ";
    private final CalculatorRepository calculatorRepository;
    private final AbstractCalculator calculator;

    public CalculatorService() {
        this.calculatorRepository = new MemoryCalculatorRepository();
        this.calculator = new Calculator();
    }

    @Override
    public int calculate(String value) {
        Expression expression = new InfixExpression(value);
        return calculator.calculate(expression);
    }

    @Override
    public void save(String expression, int result) {
        this.calculatorRepository.save(generateTotalResult(expression, result));
    }

    private String generateTotalResult(String expression, int result) {
        return expression + EQUAL + result;
    }

    @Override
    public List<String> findAll() {
        return this.calculatorRepository.findAll();
    }
}
