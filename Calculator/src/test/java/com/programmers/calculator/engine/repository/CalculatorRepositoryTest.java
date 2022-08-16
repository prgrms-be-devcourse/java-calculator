package com.programmers.calculator.engine.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorRepositoryTest {

    private CalculatorRepository calculatorRepository = new MemoryCalculatorRepository();

    @Test
    @DisplayName("계산 결과 저장")
    void testSave() {
        String str = "1 + 3 = 4";

        long sequence = calculatorRepository.save(str);

        String findStr = calculatorRepository.findOne(sequence);
        assertEquals(str, findStr);
    }

    @Test
    @DisplayName("저장소에 있는 이력 모두 조회")
    void testFindAll() {
        String str = "1 + 3 = 4";
        String str2 = "3 * 3 = 9";
        List<String> list = new ArrayList<>();
        list.add(str);
        list.add(str2);
        calculatorRepository.save(str);
        calculatorRepository.save(str2);

        List<String> result = calculatorRepository.findAll();

        assertEquals(result.size(), 2);
        assertEquals(list, result);
    }
}