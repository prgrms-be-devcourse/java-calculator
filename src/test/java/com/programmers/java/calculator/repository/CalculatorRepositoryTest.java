package com.programmers.java.calculator.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorRepositoryTest {
    CalculatorRepository calculatorRepository = new MemoryCalculatorRepository();

    @AfterEach
    void afterEach(){
        calculatorRepository.clear();
    }

    @Test
    @DisplayName("저장 테스트")
    void saveTest(){
        //given
        String exp1 = "1.0 + 2.6";
        String exp2 = "1.0 * 2.6";

        //when
        calculatorRepository.save(exp1 + " = " + "3.6");
        calculatorRepository.save(exp2 + " = " + "2.6");
        List<String> database = calculatorRepository.findAll();

        //then
        assertThat(database.size()).isEqualTo(2);
        assertThat(database.get(0)).isEqualTo("1.0 + 2.6 = 3.6");
        assertThat(database.get(1)).isEqualTo("1.0 * 2.6 = 2.6");
    }
}