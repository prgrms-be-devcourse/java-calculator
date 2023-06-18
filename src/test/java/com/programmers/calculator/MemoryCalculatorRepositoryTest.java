package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryCalculatorRepositoryTest {
    MemoryCalculatorRepository repository = new MemoryCalculatorRepository();

    @AfterEach
    void afterEach() {
        repository.clear();
    }

    @Test
    @DisplayName("계산 결과 저장에 성공한다.")
    void 계산_결과_저장() {
        // given
        CalculationResult calculationResult = new CalculationResult("1 + 2", 3);
        // when
        repository.save(calculationResult);
        // then
        int size = repository.findAll().size();
        assertThat(size).isEqualTo(1);
    }

    @Test
    @DisplayName("계산 결과 리스트 조회에 성공한다.")
    void 계산_결과_리스트_조회() {
        // given
        CalculationResult calculationResult1 = new CalculationResult("1 + 2", 3);
        repository.save(calculationResult1);

        CalculationResult calculationResult2 = new CalculationResult("2 * 3", 6);
        repository.save(calculationResult2);
        // when
        List<CalculationResult> result = repository.findAll();
        // then
        assertThat(result.size()).isEqualTo(2);
    }
}
