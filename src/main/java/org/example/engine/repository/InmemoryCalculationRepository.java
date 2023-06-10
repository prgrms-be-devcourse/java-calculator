package org.example.engine.repository;

import org.example.engine.model.CalculationResult;

import java.util.*;

public class InmemoryCalculationRepository implements CalculationRepository{
    private static Long id;
    private static Map<Long, CalculationResult> memoryDB;
    public InmemoryCalculationRepository() {
        id=0L;
        this.memoryDB = new LinkedHashMap<>();
    }
    @Override
    public int save(CalculationResult calculationResult) {
        memoryDB.put(id, calculationResult);
        id++;
        return 0;
    }
    @Override
    public List<CalculationResult> findAll() {
        return new ArrayList<>(memoryDB.values());
    }
    @Override
    public void clear() {
        memoryDB.clear();
        id=0L;
    }

    @Override
    public int size() {
        return memoryDB.size();
    }
}
