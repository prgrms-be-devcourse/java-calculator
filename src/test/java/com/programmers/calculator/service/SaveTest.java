package com.programmers.calculator.service;

import com.programmers.Console;
import com.programmers.calculator.io.Output;
import com.programmers.calculator.model.CalcData;
import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.repository.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SaveTest {
    Repository mr = new MemoryRepository();
    Output output = new Console();

    @Test
    @DisplayName("계산 결과 저장 및 불러오기")
    void resultSaveTest() {
        CalcData calcData = new CalcData("1 + 4 + 3", 8.0);
        mr.save(calcData);
        output.results(mr.getAll());
    }
}
