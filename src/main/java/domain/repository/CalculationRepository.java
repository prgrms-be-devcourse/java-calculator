package domain.repository;

import domain.IdGenerator;
import domain.model.Calculator;

import java.util.*;

public class CalculationRepository {

    private Map<Long, Calculator> repository = new HashMap<>();

    private IdGenerator idGenerator = IdGenerator.getInstance();

    public void save(Calculator calculator) {

        Long key = idGenerator.generateId();

        repository.put(key, calculator);
    }

    public List<Calculator> findAll() {

        return new ArrayList<>(repository.values());
    }
}
