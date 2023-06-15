package model.repository;

import model.entity.Calculator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryCalculatorRepository implements CalculatorRepository {
    private static final Map<Long, Calculator> store = new LinkedHashMap<>();
    private static long sequence = 0L;

    @Override
    public Calculator save(Calculator calculator) {
        calculator.setId(++sequence);
        store.put(calculator.getId(), calculator);
        return calculator;
    }

    @Override
    public List<Calculator> findAll() {
        return new ArrayList<>(store.values());
    }
}
