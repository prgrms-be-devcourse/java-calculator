package com.programmers.javaCalculator.repository;

import com.programmers.javaCalculator.domain.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalRepository implements Repository {

    private static int counter = 1;
    private static final Map<Integer, Expression> inMemory = new HashMap<>();

    @Override
    public void save(Expression ex) {
        inMemory.put(counter++, ex);
    }

    @Override
    public List<Expression> findAll() {
        return new ArrayList<>(inMemory.values());
    }

    public void clear() {
        inMemory.clear();
    }

}
