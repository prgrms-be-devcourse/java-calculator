package calculator.repository;

import calculator.model.CalculationResult;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CalculationRepository {
    private final static LinkedHashMap<Integer, CalculationResult> results = new LinkedHashMap<>();

    public void save(CalculationResult result) {
        results.put(results.size() + 1, result);
    }

    public List<CalculationResult> findAll() {
        return new ArrayList<>(results.values());
    }
}
