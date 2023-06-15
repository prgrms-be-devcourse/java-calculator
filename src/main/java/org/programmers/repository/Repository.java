package org.programmers.repository;

import org.programmers.expression.ExpressionResult;

import java.util.Map;

public interface Repository {
    void save(ExpressionResult object);

    Map<Long, ExpressionResult> getAll();
}
