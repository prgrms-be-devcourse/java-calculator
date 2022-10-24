package com.programmers.domain;


import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorResult {

    private Map<String, Integer> calculatorResult;

    public CalculatorResult() {
        this.calculatorResult = new LinkedHashMap<>();
    }

    public Map<String, Integer> getCalculatorResult() {
        return calculatorResult;
    }

    public void addResult(String inputString, int result) {
        calculatorResult.put(inputString, result);
    }
}
