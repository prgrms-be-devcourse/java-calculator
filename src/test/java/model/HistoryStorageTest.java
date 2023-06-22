package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryStorageTest {
    HistoryStorage historyStorage;

    @BeforeEach
    void setUp() {
        historyStorage = new HistoryStorage();
    }

    @Test
    @DisplayName("연산기록이 없는 경우 메시지 출력")
    void printMessageIfStorageEmpty() {

    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6", "2 * 3 + 6 - 1:11", "12 + 35 - 57:0"}, delimiter = ':')
    @DisplayName("연산기록 저장 및 조회 테스트")
    void testSaveExpressionHistory(String expression, String result) {
        // when
        historyStorage.save(expression, result);
        // then
        assertThat(historyStorage.loadAll()).contains(result);
    }

    @Test
    @DisplayName("다수의 연산기록 저장 및 조회 테스트")
    void testManyExpressionHistorySaveAndLoad() {
        // given
        List<List<String>> list = List.of(
                List.of("1 + 2 + 3", "6"),
                List.of("2 * 3 + 6 - 1", "11"),
                List.of("12 + 35 - 57", "0"),
                List.of("11111 + 1111 + 111 + 11 + 1", "12345")
        );
        // when
        for (List<String> elem : list) {
            historyStorage.save(elem.get(0), elem.get(1));
        }
        // then
        assertThat(historyStorage.loadAll()).contains(
                "1 + 2 + 3 = 6",
                "2 * 3 + 6 - 1 = 11",
                "12 + 35 - 57 = 0",
                "11111 + 1111 + 111 + 11 + 1 = 12345"
        );
    }
}
