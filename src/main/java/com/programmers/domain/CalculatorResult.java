package com.programmers.domain;


import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorResult implements Result<Integer, String> {

    private Map<Integer, String> calculatorResult;
    private int index;

    public CalculatorResult() {
        this.index = 0;
        this.calculatorResult = new LinkedHashMap<>();
    }

    @Override
    public void addResult(String result) {
        calculatorResult.put(index++, result);
    }

    @Override
    public Map<Integer, String> getResult() {
        return calculatorResult;
    }

}
