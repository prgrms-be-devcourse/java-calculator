package com.programmers.javaCalculator.repository;

import com.programmers.javaCalculator.domain.Expression;

import java.util.List;

public interface Repository {

    void save(Expression ex);

    List<Expression> findAll();

}
