package com.programmers.calculate;

import com.programmers.calculate.engine.model.History;

import java.util.*;

public class CalculatorHistory implements History {
    private final Map<Long, String> historyMap = new HashMap<>();
    private Long key = 0L;

    @Override
    public void save(String expression) {
        historyMap.put(++key, expression);
    }

    @Override
    public void findAll() {
        Collection<String> history = new Collection<>(new ArrayList<>(historyMap.values()));
        history.forEach(System.out::println);
    }
}
