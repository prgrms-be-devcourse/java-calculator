package com.programmers.engine.model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Integer, String> results = new HashMap<>();

    public void save(String result) {
        results.put(results.size() + 1, result);
    }

    public void readAllResults() {
        if (results.size() == 0) {
            System.out.println("계산 이력이 없습니다.");
            return;
        }
        System.out.println();
        results.forEach((key, value) -> System.out.println(value));
        System.out.println();;
    }
}
