package org.calculator.repository;

import org.assertj.core.api.Assertions;
import org.calculator.engine.domain.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculateRepositoryImplTest {
    CalculateRepositoryImpl calculateRepository;

    @BeforeEach
    void beforeEach() {
        calculateRepository = new CalculateRepositoryImpl();
    }
    @Test
    @DisplayName("Repository 저장 정상 작동 확인")
    void saveEquation() {
        // given
        History history = new History("1 + 1", 2.0);

        // when
        calculateRepository.save(history);

        // then
        Assertions.assertThat(calculateRepository.getHistory().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Repository 조회 정상 작동 확인")
    void getHistory() {
        // given
        History history = new History("1 + 1", 2.0);
        calculateRepository.save(history);

        // when && then
        List<History> histories = calculateRepository.getHistory();

        Assertions.assertThat(histories).contains(history);
    }

}
