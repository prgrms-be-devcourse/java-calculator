package com.programmers.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {
    private long id;
    Map<Long, CalcResult> inMemory = new HashMap<>();
    List<String> history = new ArrayList<>();

    public List<String> findAll() {
        return history;
    }

    public void save(CalcResult calcResult) {
        inMemory.put(id++, calcResult);
        history.add(calcResult.toString());
    }
}
