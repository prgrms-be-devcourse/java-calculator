package com.programmers.java.repository;

import com.programmers.java.entity.Calculation;

import java.util.*;

public class MemoryRepository implements Repository {

    private static List<Calculation> store = new ArrayList<>();

    @Override
    public void save(Calculation calculation) {
        store.add(calculation);
    }

    @Override
    public List<Calculation> findAll() {
        return store;
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
