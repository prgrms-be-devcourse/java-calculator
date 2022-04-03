package com.programmers.repository;

import com.programmers.model.Expression;

import java.util.List;

public interface ExpressionRepository {
    void save(Expression expression);
    List<Expression> findAll();
}
