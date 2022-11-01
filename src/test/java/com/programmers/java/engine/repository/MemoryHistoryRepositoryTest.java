package com.programmers.java.engine.repository;

import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryHistoryRepositoryTest {
    @Test
    @DisplayName("2개 수식 저장 후 개수 테스트")
    public void savedCount() {
        HistoryRepository historyRepository = new MemoryHistoryRepository();
        historyRepository.save(new Expression("1 + 2 + 3"));
        historyRepository.save(new Expression("1 - 2 - 3"));

        Assertions.assertEquals(historyRepository.size(), 2);
    }
}
