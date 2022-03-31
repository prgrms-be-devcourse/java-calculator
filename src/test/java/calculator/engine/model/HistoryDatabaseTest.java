package calculator.engine.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class HistoryDatabaseTest {

    private static HistoryDatabase database;

    @BeforeAll
    static void setUp() {
        database = new HistoryDatabase();
    }

    @Test
    @DisplayName("계산 이력 저장&반환 테스트")
    void testAddHistory() {
        database.addHistory("3*(4+1)-5+9/2", 14.5);
        database.addHistory("43+23/8+(2+9)*11", 166.8);
        ArrayList<String> result = database.getHistories();

        assertThat(result).isEqualTo(new ArrayList<String>(Arrays.asList("3*(4+1)-5+9/2 = 14.5", "43+23/8+(2+9)*11 = 166.8")));
    }

}
