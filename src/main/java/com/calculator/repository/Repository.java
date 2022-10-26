package com.calculator.repository;

import com.calculator.entity.Expression;

public interface Repository {
    void findAll();
    Expression findById(int id);
    int save(Expression expression);
}
