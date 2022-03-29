package service;

import entity.Data;
import org.junit.jupiter.api.Test;
import repository.CalculatorMemoryRepository;
import repository.CalculatorRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    CalculatorRepository cr = new CalculatorMemoryRepository();
    CalculatorService cs = new CalculatorService(cr);


    @Test
    void calculate() {
        String formula1 = "1 + 3 + 4"; //8.0
        String formula2 = "2 * 2 * 2"; //8.0
        String formula3 = "2 / 2 / 2"; //0.5
        String formula4 = "1 - 1 - 1"; //-1.0
        String formula5 = "2 + 2 * 4 - 1 * 10 / 5"; // 8.0;

        String result1 = cs.calculate(formula1);
        String result2 = cs.calculate(formula2);
        String result3 = cs.calculate(formula3);
        String result4 = cs.calculate(formula4);
        String result5 = cs.calculate(formula5);


        assertEquals("8.0", result1);
        assertEquals("8.0", result2);
        assertEquals("0.5", result3);
        assertEquals("-1.0", result4);
        assertEquals("8.0", result5);

    }

    @Test
    void showAllResult() {

        Data data1 = new Data(0L, "a", "resultA");
        Data data2 = new Data(1L, "b", "resultB");
        Data data3 = new Data(2L, "c", "resultC");

        cs.saveResult(data1);
        cs.saveResult(data2);
        cs.saveResult(data3);

        cr.clear();
    }
}
