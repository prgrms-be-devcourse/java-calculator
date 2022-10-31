package com.programmers.domain;


import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorResult implements Result<Integer, Formula> {

    private Map<Integer, Formula> calculatorResult;
    private int index;

    public CalculatorResult() {
        this.index = 0;
        this.calculatorResult = new LinkedHashMap<>();
    }

    @Override
    public void addResult(String problem, int answer) {
        calculatorResult.put(index++, new Formula(problem, answer));
    }

    @Override
    public Map<Integer, Formula> getResult() {
        return calculatorResult;
    }

}
