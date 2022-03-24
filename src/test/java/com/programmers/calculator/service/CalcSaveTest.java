package com.programmers.calculator.service;

import com.programmers.calculator.entity.CalcData;
import com.programmers.calculator.repository.MemoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CalcSaveTest {
    MemoryRepository mr = new MemoryRepository();

    @Test
    @DisplayName("계산 결과 저장 및 불러오기")
    void resultSaveTest() {
        CalcData calcData = new CalcData(1L, "1 + 2 * 3", 7.0);
        mr.save(calcData);
        Optional<CalcData> result = mr.get(1L);
        assertEquals(calcData.getCalcFormula(), result.get().getCalcFormula());
        assertEquals(calcData.getResult(), result.get().getResult());
    }

    @Test
    @DisplayName("계산 결과 불러오기 실패")
    void resultGetFailTest() {
        CalcData calcData = new CalcData(1L, "1 + 2 * 3", 7.0);
        mr.save(calcData);
        Optional<CalcData> result = mr.get(2L);
        assertTrue(result.isEmpty());
    }
}
