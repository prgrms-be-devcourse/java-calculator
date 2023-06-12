package com.programmers.repository;

import com.programmers.model.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryCalculationRepositoryTest {
    CalculationRepository repository = new InMemoryCalculationRepository();

    @Test
    @DisplayName("계산이력 저장 테스트")
    void 계산이력저장() throws Exception {
        //given
        CalculationResult result1 = new CalculationResult("1 + 2 * 3 ", 7);
        CalculationResult result2 = new CalculationResult("2 + 4 * 3 - 5 * 2 ", 4);
        //when
        repository.save(result1);
        repository.save(result2);
        //then
        List<CalculationResult> record = repository.findAll();
        System.out.println(record.get(0));
        assertThat(record.size()).isEqualTo(2);
        assertThat(record).contains(result1, result2);
        assertThat(record.get(0)).isEqualTo(result1);
        assertThat(record.get(1)).isEqualTo(result2);
    }
}