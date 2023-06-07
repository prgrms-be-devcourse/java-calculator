package com.programmers.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorHistory {

    private final Map<String, Double> storage = new LinkedHashMap<>();

    public void save(String formula, double answer) {
        storage.put(formula, answer);
    }

    public String findAll() {
        StringBuilder sb = new StringBuilder();

        if (storage.isEmpty()) {
            return "조회할 기록이 없습니다.";
        }

        for (String key : storage.keySet()) {
            String formula = key;
            double answer = storage.get(key);
            sb.append(formula).append(" = ").append(answer).append("\n");
        }
        return sb.toString();
    }
}
