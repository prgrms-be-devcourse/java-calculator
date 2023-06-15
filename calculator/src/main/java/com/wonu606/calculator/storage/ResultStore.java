package com.wonu606.calculator.storage;

import com.wonu606.calculator.model.CalculationResult;
import com.wonu606.calculator.util.CalculatorMessage;
import java.util.ArrayList;
import java.util.List;

public class ResultStore implements Persistence {

    private final List<CalculationResult> store = new ArrayList<>();

    @Override
    public void saveResult(CalculationResult calculationResult) {
        store.add(calculationResult);
    }

    @Override
    public CalculationResult findResult(int sequence) {
        try {
            return store.get(sequence - 1);
        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(CalculatorMessage.INVALID_ORDER.message);
        }
    }

    @Override
    public List<CalculationResult> findAllResult() {
        return new ArrayList<>(store);
    }

    @Override
    public void clear() {
        store.clear();
    }
}
