package com.programmers.calculator.service;

import com.programmers.calculator.entity.CalcData;
import com.programmers.calculator.repository.MemoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalcSaveTest {
    MemoryRepository mr = new MemoryRepository();

    @Test
    @DisplayName("계산 결과 저장 및 불러오기")
    void resultSaveTest() {
        CalcData calcData = new CalcData("1 + 4 + 3", 8.0);
        mr.save(calcData);
        mr.printAll();
    }
}
