package com.programmers.calculate;

import com.programmers.calculate.engine.model.History;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorHistory implements History {
    private final Map<Long, String> historyMap = new HashMap<>();
    private Long key = 0L;

    @Override
    public void save(String expression) {
        historyMap.put(++key, expression);
    }

    @Override
    public void findAll() {
        List<String> history = new ArrayList<>(historyMap.values());
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }
}
