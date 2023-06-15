package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.ExpressionResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CalMemoryRepository implements MemoryRepository {

    private static final Map<Long, ExpressionResult> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public ExpressionResult save(ExpressionResult expressionResult) {

        expressionResult.setId(++sequence);

        store.put(expressionResult.getId(), expressionResult);

        return expressionResult;
    }

    @Override
    public ExpressionResult findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<ExpressionResult> findAll() {
        return new ArrayList<>(store.values());
    }

}
