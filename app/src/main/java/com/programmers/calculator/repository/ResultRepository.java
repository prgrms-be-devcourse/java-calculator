package com.programmers.calculator.repository;

import com.programmers.calculator.domain.OperationResult;

import java.util.Optional;
public interface ResultRepository {
    void save(OperationResult operationResult);
    Optional<OperationResult> findById(long id);
    boolean isEmpty();
}
