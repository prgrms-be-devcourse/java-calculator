package com.programmers.java.repository;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

    private static List<String> calculationResults = new ArrayList<>();

    public void save(String expression, String result) {
        calculationResults.add(expression + "=" + result);
    }

    public List<String> getCalculationResults() {
        return calculationResults;
    }
}