package com.programmers.calculator.repository;

import com.programmers.calculator.vo.Formula;

import java.util.*;

public class MemoryRepository implements Repository<Formula> {
    private static final Map<Integer, Formula> store = new LinkedHashMap<>();
    private static MemoryRepository repository;

    private MemoryRepository() {

    }

    public static MemoryRepository getInstance() {
        if (repository == null) {
            repository = new MemoryRepository();
        }
        return repository;
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
