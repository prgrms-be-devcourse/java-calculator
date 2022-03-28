package com.programmers.calculator.repository;

import com.programmers.calculator.vo.Formula;

import java.util.*;

public class MemoryRepository implements Repository<Formula> {
    private final Map<Integer, Formula> store;

    public MemoryRepository() {
        store = new LinkedHashMap<>();
    }

    @Override
    public Formula save(Formula formula) {
        store.put(formula.hashCode(), formula);
        return formula;
    }

    @Override
    public List<Formula> findAll() {
        ArrayList<Formula> list = new ArrayList<>();
        store.forEach((key, value) -> list.add(value));
        return list;
    }
}
