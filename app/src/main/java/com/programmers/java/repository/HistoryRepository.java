package com.programmers.java.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class HistoryRepository implements Repository {
    private static HashMap<String, Integer> repository = new LinkedHashMap<>();

    @Override
    public void save(String formula, Integer result) {
        repository.put(formula, result);
    }

    @Override
    public boolean haveFormulaResult(String formula) {
        return repository.containsKey(formula);
    }

    @Override
    public int findFormulaResult(String formula) {
        return repository.get(formula);
    }

    @Override
    public List<String> findAllHistory() {
        List<String> history = new ArrayList<>();

        repository.keySet()
                .forEach(i -> history.add(i + "=" + repository.get(i).toString()));

        return history;
    }
}
