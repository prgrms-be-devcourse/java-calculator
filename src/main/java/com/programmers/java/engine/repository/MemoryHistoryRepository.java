package com.programmers.java.engine.repository;

import com.programmers.java.engine.model.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryHistoryRepository implements HistoryRepository {
    private final Map<Integer, Expression> history;
    private int counter;

    public MemoryHistoryRepository() {
        this.counter = 0;
        this.history = new HashMap<>();
    }

    @Override
    public List<Expression> load() {
        List<Expression> result = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            result.add(history.get(i));
        }

        return result;
    }

    @Override
    public void save(Expression expression) {
        history.put(counter++, expression);
    }

    @Override
    public void clear() {
        counter = 0;
        history.clear();
    }

    @Override
    public int size() {
        return history.size();
    }


}
