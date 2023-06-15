package org.programmers.repository;

import org.programmers.domain.expression.ExpressionResult;

import java.util.Map;

public interface Repository {

    void save(ExpressionResult object);

    Map<Long, ExpressionResult> getAll();
}
