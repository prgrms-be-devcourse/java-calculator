package com.programmers.calculator.storage;

import com.programmers.calculator.entity.Operation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class OperationMemoryStorage implements OperationRepository {

    private final Map<Long, Operation> repository;
    private long id = 0L;

    public OperationMemoryStorage() {
        repository = new LinkedHashMap<>();
    }

    @Override
    public void save(Operation operation) {
        repository.put(id++, operation);
    }

    @Override
    public Optional<Operation> findById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public boolean isEmpty() {
        return repository.isEmpty();
    }

    @Override
    public long length() {
        return id;
    }
}
