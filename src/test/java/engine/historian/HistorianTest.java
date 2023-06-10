package engine.historian;

import com.devcourse.engine.historian.Historian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HistorianTest {
    @Test
    void saveHistoryTest1() {
        Historian historian = new Historian();
        historian.saveHistory(List.of("1", "+", "1"), 2.0);
        Assertions.assertEquals(1, historian.getLastIndex());
    }

    @Test
    void saveHistoryTest2() {
        Historian historian = new Historian();
        historian.saveHistory(List.of("1", "+", "2", "*", "5", "-", "8", "/", "4"), 9.0);
        Assertions.assertEquals(1, historian.getLastIndex());
    }

    @Test
    void saveHistoryTest3() {
        Historian historian = new Historian();
        Assertions.assertEquals(
            "표시할 이력이 없습니다.",
            historian.getHistory(historian.getLastIndex())
        );
    }
}
