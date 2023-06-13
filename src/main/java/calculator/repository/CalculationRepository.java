package calculator.repository;

import calculator.model.CalculationResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CalculationRepository {
    private static Map<Integer, CalculationResult> results;
    private static AtomicInteger idCounter;


    public CalculationRepository() {
        results = new ConcurrentHashMap<>();
        idCounter = new AtomicInteger(0);
    }

    public void save(CalculationResult result) {
        results.put(idCounter.getAndIncrement(), result);
    }

    public Map<Integer, CalculationResult> findAll() {
        return results;
    }

    void clearStore(){
        results.clear();
    }
}
