package me.programmers.calculator.engine.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    History history = new History();

    @Test
    void saveMemoryTest() {
        String problem = "1+2";
        int sum = 3;

        history.saveMemory(problem, sum);

        assertEquals(history.getMemory().get(1), problem+"="+sum);
    }
}