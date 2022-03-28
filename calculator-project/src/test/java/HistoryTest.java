import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HistoryTest {
    History history = new History();

    @Test
    void testSave() {
        String operation = "2+3-4";
        double number = 1;
        history.save(operation, number);
        int historyNum = history.count();
        Assertions.assertEquals(historyNum, 1);
    }

    @Test
    void testListAll() {
        List<String> expect = Arrays.asList("27/3-2 = 1.0","234-3 = 1.0","9345+1 = 1.0");
        historySave("27/3-2");
        historySave("234-3");
        historySave("9345+1");
        List<String> result = history.getList();
        Assertions.assertLinesMatch(result, expect);
    }

    @Test
    void testIsExist(){
        String operation = "27-3";
        historySave(operation);
        Assertions.assertEquals(history.isExist(operation),true);
    }

    /* helper method */
    void historySave(String operation) {
        double number = 1;
        history.save(operation, number);
    }
}
