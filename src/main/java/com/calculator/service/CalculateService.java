package com.calculator.service;

import com.calculator.common.Calculator;
import com.calculator.entity.Expression;
import com.calculator.repository.Repository;

public class CalculateService {

    private final Repository repository;
    private final Calculator calculator;

    public CalculateService(Repository repository, Calculator calculator) {
        this.repository = repository;
        this.calculator = calculator;
    }

    public void getMap() {
        repository.findAll();
    }

    public String calculate(String inputString) {
        String calculatedValue = calculator.calculate(inputString);
        Expression expression = saveExpression(inputString, calculatedValue);

        return expression.getResult();
    }

    public Expression saveExpression(String input, String calculatedValue) {
        // 계산 완료 후 map에 저장
        Expression expression = new Expression(input, calculatedValue);
        repository.save(expression);

        return expression;
    }

}
