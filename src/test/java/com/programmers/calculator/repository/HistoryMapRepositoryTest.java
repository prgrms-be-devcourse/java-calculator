package com.programmers.calculator.repository;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryMapRepositoryTest {

    HistoryRepository repository = new HistoryMapRepository();

    @DisplayName("repository 정상적으로 저장되는지 확인")
    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3, 7",
            "3 + 2 * 3 / 3, 5"
    })
    void repository_right_work(String inputExpression, BigDecimal expectedResult) {

        // given
        Expression expression = new Expression(inputExpression);
        CalculationResult calculationResult = new CalculationResult(expectedResult);
        CalculationHistory result = new CalculationHistory(expression, calculationResult);

        // when
        repository.save(result);

        // then
        List<CalculationHistory> all = repository.findAll();

        assertThat(all.size()).isEqualTo(1);
        assertThat(all).contains(result);
        assertThat(all.get(0)).isEqualTo(result);

    }

}