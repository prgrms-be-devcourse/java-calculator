package com.calculator.repository;

import com.calculator.entity.Expression;

import java.util.Optional;

public interface Repository {
    int findAll();
    Optional<Expression> findByInfix(String infix);
    int save(Expression expression);
}
