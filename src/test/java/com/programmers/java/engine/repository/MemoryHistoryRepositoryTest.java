package com.programmers.java.engine.repository;

import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryHistoryRepositoryTest {
    @Test
    @DisplayName("2개 수식 저장 후 개수 테스트")
    public void savedCountTest() {
        HistoryRepository historyRepository = new MemoryHistoryRepository();
        historyRepository.save(new Expression("1 + 2 + 3"));
        historyRepository.save(new Expression("1 - 2 - 3"));

        Assertions.assertEquals(historyRepository.size(), 2);
    }

    @Test
    @DisplayName("수식이 없는 경우 저장 개수가 0인지 테스트")
    public void nonSavedCountTest() {
        HistoryRepository historyRepository = new MemoryHistoryRepository();

        Assertions.assertEquals(historyRepository.size(), 0);
    }
}
