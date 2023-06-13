package calculator.repository;

import calculator.model.CalculationResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CalculationRepository {
    private final static Map<Integer, CalculationResult> results = new ConcurrentHashMap<>();

    public void save(CalculationResult result) {
        results.put(results.size() + 1, result);
    }

    public Map<Integer, CalculationResult> findAll() {
        return results;
    }
}
