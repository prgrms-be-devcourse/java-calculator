package com.devcourse.java.domain.storage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StorageTest {
    private MemoryStorage storage = new MemoryStorage();

    @Test
    @DisplayName("계산결과 저장하기 테스트")
    void saveTest() {
        // given
        final String expression = "test";
        final int result = 25;
        CalculateResult calculateResult = new CalculateResult(expression, result);

        // when
        storage.save(calculateResult);

        // then
        List<CalculateResult> calculateResults = storage.fetchAll();
        assertThat(calculateResults.isEmpty()).isFalse();
        assertThat(storage.getId()).isEqualTo(calculateResults.size() + 1);
    }

    @Test
    @DisplayName("계산결과 가져오기 테스트")
    void fetchAllTest() {
        // given
        final String expression = "test";
        final int size = 10;

        for (int i = 0; i < size; i++) {
            CalculateResult calculateResult = new CalculateResult(expression + i, i);
            storage.save(calculateResult);
        }

        // when
        List<CalculateResult> calculateResults = storage.fetchAll();

        // then
        assertThat(calculateResults.isEmpty()).isFalse();
        assertThat(calculateResults.size()).isEqualTo(size);
    }
}
