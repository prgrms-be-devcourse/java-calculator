package org.programmers.repository;

import org.programmers.expression.ExpressionResult;

import java.util.HashMap;
import java.util.Map;

public class ExpressionRepository implements Repository{
    private final Map<Long, ExpressionResult> historyMap;

    private long idx = 0L;

    public ExpressionRepository() {
        this.historyMap = new HashMap<>();
    }

    @Override
    public void save(ExpressionResult expression) {
        historyMap.put(idx++, expression);
    }

    @Override
    public Map<Long, ExpressionResult> getAll() {
        return historyMap;
    }
}
