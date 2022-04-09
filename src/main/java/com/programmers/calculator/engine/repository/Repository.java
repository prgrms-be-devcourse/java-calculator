package com.programmers.calculator.engine.repository;

import com.programmers.calculator.engine.io.Output;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private final Map<String, Integer> repository = new LinkedHashMap<>();

    // 추가
    public void put(String expression, int result) {
        repository.put(expression, result);
    }

    // 출력
    public Map<String, Integer> getRepository() {
        return repository;
    }
}
