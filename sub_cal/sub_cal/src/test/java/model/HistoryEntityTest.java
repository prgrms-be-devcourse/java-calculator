package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HistoryEntityTest {
    private HistoryEntity historyEntity = new HistoryEntity();

    @BeforeEach
    void setHistoryEntity(){
        historyEntity = new HistoryEntity();
        historyEntity.addHistory("1 + 1","2");
        historyEntity.addHistory("1 * 3 + 6","9");
    }

    @Test
    void getHistory() {
        List<String> historyList = new ArrayList<>();
        historyList.add("1 + 1 = 2");
        historyList.add("1 * 3 + 6 = 9");
        assertEquals(historyList,historyEntity.getHistory());
    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(Arrays.asList("1 + 1 = 2","1 * 3 + 6 = 9"))
        );
    }

}
