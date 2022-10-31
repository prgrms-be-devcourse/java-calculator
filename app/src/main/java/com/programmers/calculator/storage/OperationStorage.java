package com.programmers.calculator.storage;

import com.programmers.calculator.entity.Operation;

import java.util.Optional;

public interface OperationStorage {
    void save(Operation operation);
    Optional<Operation> findById(long id);
    boolean isEmpty();
    long totalCount();
}
