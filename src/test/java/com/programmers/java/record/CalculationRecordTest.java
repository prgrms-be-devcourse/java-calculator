package com.programmers.java.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculationRecordTest {

    private CalculationRecord calculationRecord;

    @BeforeEach
    public void setUp() {
        calculationRecord = new CalculationRecord();
    }

    @Test
    void saveAndGetCalculationResults() {
        calculationRecord.save("8/4", "2.0");
        calculationRecord.save("5+3", "8.0");

        List<String> calculationResults = calculationRecord.getCalculationResults();

        Assertions.assertEquals(2, calculationResults.size());
    }
}