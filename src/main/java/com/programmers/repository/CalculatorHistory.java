package com.programmers.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorHistory {

    private CalculatorHistory() {
    }

    private final Map<String, Double> storage = new LinkedHashMap<>();

    public void save(String formula, double answer) {
        storage.put(formula, answer);
    }

    public Map<String, Double> findAll() {
        Map<String, Double> map = new LinkedHashMap<>(storage);
        return map;
    }

    public static class LazyHolder {
        private static final CalculatorHistory instance = new CalculatorHistory();
    }

    public static CalculatorHistory getInstance() {
        return LazyHolder.instance;
    }

}
