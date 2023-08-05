package programmers.java.calulator.common.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static programmers.java.calulator.common.repository.History.HISTORY_FORMAT_DELIMITER;

public class HistoryTest {
    static class TestHistory extends History {
        public TestHistory(String expression, Integer result) {
            super(expression, result);
        }
    }

    @Test
    @DisplayName("오버라이딩 한 toString이 잘 작동하는지 확인하는 테스트")
    void toString_테스트() {
        //given
        String expression = "1 + 1";
        Integer result = 2;
        TestHistory history = new TestHistory(expression, result);
        String expectedOutput = expression + HISTORY_FORMAT_DELIMITER + result;

        //when
        String actualOutput = history.toString();

        //then
        assertEquals(expectedOutput, actualOutput);
    }
}
