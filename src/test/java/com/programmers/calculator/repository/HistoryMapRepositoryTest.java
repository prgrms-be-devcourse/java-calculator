package com.programmers.calculator.repository;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryMapRepositoryTest {

    HistoryRepository repository = new HistoryMapRepository();

    @DisplayName("repository 정상적으로 저장되는지 확인")
    @Test
    void repository_right_work() {

        //given
        Expression expression1 = new Expression("1 + 2 * 3");
        Expression expression2 = new Expression("3 + 2 * 3 / 3");
        CalculationResult calculationResult1 = new CalculationResult(new BigDecimal(7));
        CalculationResult calculationResult2 = new CalculationResult(new BigDecimal(5));

        CalculationHistory result1 = new CalculationHistory(expression1, calculationResult1);
        CalculationHistory result2 = new CalculationHistory(expression2, calculationResult2);

        //when
        repository.save(result1);
        repository.save(result2);

        //then
        List<CalculationHistory> all = repository.findAll();
        /**
         * 1. size check
         * 2. reposity.contains(r1, r2)
         * 3. reposity.get(0) = 7
         * 4. reposity.get(1) = 5
         */
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(result1, result2);
        assertThat(all.get(0)).isEqualTo(result1);
        assertThat(all.get(1)).isEqualTo(result2);
    }
}