package com.programmers.java.repository;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@Getter
public class ResultRepository {

    private static ArrayList<String> calculationResults = new ArrayList<>();

    public void save(String expression, String result) {
        calculationResults.add(expression + "=" + result);
    }

    public ArrayList<String> getCalculationResults() {
        return calculationResults;
    }
}