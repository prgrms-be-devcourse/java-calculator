package com.programmers.java.engine.repository;

import com.programmers.java.engine.exception.HistoryException;
import com.programmers.java.engine.model.Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryHistoryRepository implements HistoryRepository {
    private int counter;
    private Map<Integer, Expression> map;

    public MemoryHistoryRepository() {
        this.counter = 0;
        this.map = new HashMap<>();
    }

    @Override
    public List<Expression> load() {
        if (map.isEmpty()) {
            throw new HistoryException("저장된 내역이 없습니다.\n");
        }

        List<Expression> result = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    @Override
    public void save(Expression expression) {
        map.put(counter++, expression);
    }

    @Override
    public void clear() {
        counter = 0;
        map.clear();
    }
}
