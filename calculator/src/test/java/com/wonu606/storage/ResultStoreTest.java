package com.wonu606.storage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.wonu606.calculator.model.CalculationResult;
import com.wonu606.calculator.storage.Persistence;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultStoreTest {

    @Test
    @DisplayName("저장")
    void testSave() {
        // given
        Persistence store;

        // when
        CalculationResult calculationResult = new CalculationResult("2 + 2", 4.0d);
        store.saveResult(calculationResult);

        // then
        assertThat(store.findAllResult().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("순서로 결과 찾기")
    void testFind() {
        // given
        Persistence store;

        // when
        CalculationResult saveResult = new CalculationResult("5 + 10", 15.0d);
        store.saveResult(saveResult);

        // then
        CalculationResult foundResult = store.findResult(1);
        assertThat(foundResult).isEqualTo(saveResult);
    }

    @Test
    @DisplayName("1 미만의 수로 찾은 경우 예외 발생")
    void testFindNumberLessThan1() {
        // given
        Persistence store;

        // then
        CalculationResult saveResult = new CalculationResult("5 + 10", 15.0d);
        store.saveResult(saveResult);

        // then
        assertThatThrownBy(() -> store.findResult(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 순번입니다.");
    }

    @Test
    @DisplayName("사이즈 초과의 수로 찾은 경우 예외 발생")
    void testFindNumberMoreThanSize() {
        // given
        Persistence store;

        // when
        CalculationResult saveResult = new CalculationResult("5 + 10", 15.0d);
        store.saveResult(saveResult);

        // then
        assertThatThrownBy(() -> store.findResult(store.findAllResult().size() + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 순번입니다.");
    }

    @Test
    @DisplayName("모두 찾기")
    void testFindAll() {
        // given
        Persistence store;

        // when
        List<CalculationResult> results = new ArrayList<>();
        results.add(new CalculationResult("5 + 6", 11.0d));
        results.add(new CalculationResult("5 + 6", 11.0d));

        for (CalculationResult result : results) {
            store.saveResult(result);
        }

        // then
        List<CalculationResult> foundResults = store.findAllResult();
        for (CalculationResult foundResult : foundResults) {
            assertThat(results.indexOf(foundResult)).isNotEqualTo(-1);
        }
    }

    @Test
    @DisplayName("클리어")
    void testClear() {
        // given
        Persistence store;

        // when
        store.saveResult(new CalculationResult("11 + 6", 17.0d));
        store.saveResult(new CalculationResult("11 + 10", 21.0d));

        // then
        assertThat(store.findAllResult().size()).isNotEqualTo(0);
        store.clear();
        assertThat(store.findAllResult().size()).isEqualTo(0);
    }
}
