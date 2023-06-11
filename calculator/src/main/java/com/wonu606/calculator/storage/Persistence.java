package com.wonu606.calculator.storage;

import com.wonu606.calculator.model.CalculationResult;
import java.util.List;

public interface Persistence {

    void saveResult(CalculationResult calculationResult);

    CalculationResult findResult(int sequence);

    List<CalculationResult> findAllResult();

    void clear();
}
