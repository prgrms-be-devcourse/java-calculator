package org.domain.repository;

import org.domain.model.Calculator;

import java.util.*;

public class CalculationRepository {

    private Map<Long, Calculator> repository = new HashMap<>();

    private IdGenerator idGenerator = IdGenerator.getInstance();

    public void save(Calculator calculator) {

        repository.put(idGenerator.generateId(), calculator);
    }

    public List<Calculator> findAll() {

        return new ArrayList<>(repository.values());
    }
}
