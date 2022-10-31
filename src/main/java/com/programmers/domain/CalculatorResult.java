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
    public void addResult(Formula formula) {
        calculatorResult.put(index++, formula);
    }

    @Override
    public Map<Integer, Formula> getResult() {
        return calculatorResult;
    }

}
