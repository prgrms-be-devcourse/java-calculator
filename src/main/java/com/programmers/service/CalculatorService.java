package com.programmers.service;

import com.programmers.model.ExpressionResult;
import com.programmers.repository.CalculatorRepository;
import com.programmers.util.CalculatorProcessor;

import java.util.List;


public class CalculatorService {
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    //계산 수행 후 저장
    public int calculate(String expression) {
        //계산
        int result = CalculatorProcessor.calculateExpression(expression);

        //저장
        calculatorRepository.save(new ExpressionResult(expression, result));
        return result;
    }

    //history 조회
    public List<ExpressionResult> getHistories() {
        return calculatorRepository.findAll();
    }


}
