package com.programmers.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorHistory {

    private final Map<String, Double> storage = new LinkedHashMap<>();
    private final StringBuilder sb = new StringBuilder();

    public void save(String formula, double answer) {
        storage.put(formula, answer);
    }

    public String findAll() {
        
        // 콘솔로 역할을 주자
        if (storage.isEmpty()) {
            return "조회할 기록이 없습니다.";
        }

        storage.keySet().forEach(key -> {
            double answer = storage.get(key);
            sb.append(key).append(" = ").append(answer).append("\n");

        });
        return sb.toString();
    }
}
