package com.programmers.java.engine.repository;

import com.programmers.java.engine.model.CacheFormulResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
public class FormulaRepository implements MemoryRepository, CacheMemory{

    private final List<CacheFormulResult> history = new ArrayList<>();
    private final LinkedHashMap<String, Long> Cache = new LinkedHashMap<>();

    @Override
    public void save(String formula, Long result) {
        history.add(new CacheFormulResult(formula,result));
        Cache.put(formula, result);
    }

    @Override
    public void findAll() {
        history.forEach((v) -> System.out.println(v.getFormula() + " = " + v.getResult()));
    }

    @Override
    public int size() {
        return history.size();
    }

    @Override
    public boolean isCacheExit(String s) {
        return Cache.containsKey(s);
    }

    @Override
    public long cache(String s) {
        return Cache.get(s);
    }
}
