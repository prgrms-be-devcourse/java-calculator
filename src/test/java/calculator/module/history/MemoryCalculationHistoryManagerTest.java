package calculator.module.history;

import calculator.DependencyConfigurer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCalculationHistoryManagerTest {
    DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
    MemoryCalculationHistoryManager historyManager =  new MemoryCalculationHistoryManager(dependencyConfigurer.userInterface());

    @ParameterizedTest
    @CsvFileSource(resources = "/history-test-data.csv",delimiter = ',')
    public void printAllCalculationHistoryTest(String expression,Double calculationResult, String expectedOutput){
        expectedOutput += "\n";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        CalculationHistory history = new CalculationHistory(expression,calculationResult);
        historyManager.saveCalculationResultToHistory(expression,history);

        historyManager.printAllCalculationHistory();

        assertEquals(expectedOutput,out.toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/history-test-data.csv",delimiter = ',')
    public void saveCalculationResultToHistory(String expression,Double calculationResult, String output) {
        CalculationHistory history = new CalculationHistory(expression,calculationResult);

        historyManager.saveCalculationResultToHistory(expression,history);
        CalculationHistory findOne = historyManager.findCalculationHistoryByExpression(expression);

        assertNotNull(findOne);
        assertFalse(historyManager.calculationHistoryNotExist());
        Assertions.assertThat(history).isEqualTo(findOne);
    }
}