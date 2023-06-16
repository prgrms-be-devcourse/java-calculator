package engine.historian;

import com.devcourse.engine.model.histories.Histories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HistoriesTest {
    @Test
    void saveHistoryTest1() {
        Histories histories = new Histories();
        histories.saveHistory(List.of("1", "+", "1"), 2.0);
        Assertions.assertEquals(1, histories.getLastIndex());
    }

    @Test
    void saveHistoryTest2() {
        Histories histories = new Histories();
        histories.saveHistory(List.of("1", "+", "2", "*", "5", "-", "8", "/", "4"), 9.0);
        Assertions.assertEquals(1, histories.getLastIndex());
    }

    @Test
    void saveHistoryTest3() {
        Histories histories = new Histories();
        Assertions.assertEquals(
            "표시할 이력이 없습니다.",
            histories.getHistory(histories.getLastIndex())
        );
    }
}
