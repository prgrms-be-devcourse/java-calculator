package calculator.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CalculationRepository {
    private final static LinkedHashMap<Integer, String> results = new LinkedHashMap<>();

    public void save(String calculation) {
        results.put(results.size() + 1, calculation);
    }

    public List<String> findAll() {
        return new ArrayList<>(results.values());
    }
}
