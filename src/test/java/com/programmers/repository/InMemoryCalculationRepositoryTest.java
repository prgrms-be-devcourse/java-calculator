package com.programmers.repository;

import com.programmers.core.data.CalculationResult;
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
        CalculationResult[] results = {new CalculationResult("1 + 2 * 3 ", 7), new CalculationResult("2 + 4 * 3 - 5 * 2 ", 4)};
        //when
        for (CalculationResult result : results) {
            repository.save(result);
        }
        //then
        List<CalculationResult> record = repository.findAll();
        assertThat(record.size()).isEqualTo(results.length);
        assertThat(record).containsExactlyInAnyOrder(results);
    }
}