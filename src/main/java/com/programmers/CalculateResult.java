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
        results.forEach((key, value) -> System.out.println(value));
    }
}
