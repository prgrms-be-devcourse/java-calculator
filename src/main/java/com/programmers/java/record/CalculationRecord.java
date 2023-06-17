package com.programmers.java.record;

import java.util.ArrayList;
import java.util.List;

public class CalculationRecord {

    private static List<String> calculationResults = new ArrayList<>();

    public void save(String expression, String result) {
        calculationResults.add(expression + "=" + result);
    }

    public List<String> getCalculationResults() {
        return calculationResults;
    }
}