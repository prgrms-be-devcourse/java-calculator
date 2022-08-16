package com.programmers.repository;

import com.programmers.model.Expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryExpressionRepository implements ExpressionRepository {
    private static final List<Expression> store = new ArrayList<>();

    @Override
    public void save(Expression expression) {
        store.add(expression);
    }

    @Override
    public List<Expression> findAll() {
        return Collections.unmodifiableList(store);
    }
}
