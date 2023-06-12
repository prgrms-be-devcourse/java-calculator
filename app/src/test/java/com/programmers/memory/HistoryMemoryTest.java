package com.programmers.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryMemoryTest {
    static final HistoryMemory historyMemory = new HistoryMemory(); // 계산 결과 메모리

    @Test
    void memoryTest() {
        String inputExpression1 = "1 + 2";
        String inputExpression2 = "1 + 2 * 3";
        String inputExpression3 = "3 - 2 * 2";

        historyMemory.saveHistory(inputExpression1, 3);
        historyMemory.saveHistory(inputExpression2, 7);
        historyMemory.saveHistory(inputExpression3, -1);


        String history = historyMemory.getHistory();

        String expectedHistory1 = inputExpression1 + " = 3.00\n";
        String expectedHistory2 = inputExpression2 + " = 7.00\n";
        String expectedHistory3 = inputExpression3 + " = -1.00\n";

        assertEquals(expectedHistory1 + expectedHistory2 + expectedHistory3, history);
    }
}
