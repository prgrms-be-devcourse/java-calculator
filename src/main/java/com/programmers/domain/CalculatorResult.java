package com.programmers.domain;


import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorResult implements Result<String, Integer> {

    private Map<String, Integer> calculatorResult;

    public CalculatorResult() {
        this.calculatorResult = new LinkedHashMap<>();
    }

    @Override
    public void addResult(String input, Integer result) {
        calculatorResult.put(input, result);
    }

    @Override
    public Map<String, Integer> getResult() {
        return calculatorResult;
    }

}
