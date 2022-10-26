package com.calculator.repository;

import com.calculator.entity.Expression;

public interface Repository {
    void findAll();
    Expression findByInfix(String infix);
    int save(Expression expression);
}
