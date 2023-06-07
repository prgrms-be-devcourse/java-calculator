package com.programmers;

import com.programmers.model.Result;

import java.util.HashMap;
import java.util.Map;

public class CalculateResult implements Result {
    private final Map<Integer, String> results = new HashMap<>();

    @Override
    public void save(String result) {
        results.put(results.size() + 1, result);
    }

    @Override
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
