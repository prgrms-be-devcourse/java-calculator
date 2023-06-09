package calculator.repository;

import java.util.LinkedHashMap;

public class CalculationRepository {
    private final static LinkedHashMap<Integer, String> results = new LinkedHashMap<>();

    public void save(String calculation) {
        results.put(results.size() + 1, calculation);
    }

    public LinkedHashMap<Integer, String> findAll() {
        return results;
    }
}
