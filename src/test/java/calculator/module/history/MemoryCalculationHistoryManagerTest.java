package calculator.module.history;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCalculationHistoryManagerTest {
    MemoryCalculationHistoryManager historyManager =  new MemoryCalculationHistoryManager();
    @Test
    public void printAllCalculationHistoryTest(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        historyManager.saveCalculationResultToHistory("1 + 3",4.0);
        historyManager.saveCalculationResultToHistory("200 * 3 + 6",606.0);
        historyManager.printAllCalculationHistory();
        assertFalse(historyManager.calculationHistoryNotExist());
        assertEquals("1 + 3 = 4.0\n200 * 3 + 6 = 606.0\n",out.toString());
    }

    @Test
    public void saveCalculationResultToHistory() {
        historyManager.saveCalculationResultToHistory("1 + 3",4.0);
        assertFalse(historyManager.calculationHistoryNotExist());
    }
}