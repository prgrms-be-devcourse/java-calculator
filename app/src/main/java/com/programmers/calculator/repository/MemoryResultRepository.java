package com.programmers.calculator.repository;

import com.programmers.calculator.domain.OperationResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryResultRepository implements ResultRepository {

    private final Map<Long, OperationResult> repository = new LinkedHashMap<>();
    private static long id = 0L;

    @Override
    public void save(OperationResult operationResult) {
        operationResult.setId(id);
        repository.put(id++, operationResult);
    }

    @Override
    public Optional<OperationResult> findById(long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public boolean isEmpty() {
        return repository.isEmpty();
    }
}
