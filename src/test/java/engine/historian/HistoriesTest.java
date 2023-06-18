package engine.historian;

import com.devcourse.engine.model.histories.Histories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class HistoriesTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of("1", "+", "1"), 2.0, 1),
                Arguments.of(List.of("1", "+", "2", "*", "5", "-", "8", "/", "4"), 9.0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void saveHistoryTest(List<String> infix, double result, int expected) {
        Histories histories = new Histories();

        histories.saveHistory(infix, result);

        Assertions.assertEquals(expected, histories.getLastIndex());
    }

    @Test
    void saveHistoryTest3() {
        Histories histories = new Histories();
        Assertions.assertNull(histories.getHistory(histories.getLastIndex()));
    }
}
