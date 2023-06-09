package calculator.service;

import calculator.domain.model.HistoryModel;
import calculator.domain.repository.CalculatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {

    private CalculatorManager calculatorManager;
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorManager = new CalculatorManager();
        calculatorService = new CalculatorService(new CalculatorRepository(), calculatorManager);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 * 5 / 4 + 7 * 2 : 4*5/4+7*2", "15 * 2 - 17 : 15*2-17"}, delimiter = ':')
    @DisplayName("CalculatorManager.removeSpaces(String) - 공백 제거 테스트")
    void 공백_제거(String input, String output) {
        assertEquals(calculatorManager.removeSpaces(input), output);
    }

    @ParameterizedTest
    @CsvSource(value = {"5 + 7 + 17 : 29", "1 + 2 : 3", "5 + 2 : 7"}, delimiter = ':')
    @DisplayName("CalculatorService.calculate(String) - 덧셈 연산 테스트")
    void 덧셈(String input, String output) {
        //given, when
        HistoryModel historyModel = calculatorService.calculate(input);

        //then
        assertEquals(historyModel.getFormula(), calculatorManager.removeSpaces(input));
        assertEquals(historyModel.getAnswer(), output);
    }

    @ParameterizedTest
    @CsvSource(value = {"7 - 2 : 5", "1 - 2 : -1", "10 - 7 - 1 : 2"}, delimiter = ':')
    @DisplayName("CalculatorService.calculate(String) - 뺄셈 연산 테스트")
    void 뺄셈(String input, String output) {
        //given, when
        HistoryModel historyModel = calculatorService.calculate(input);

        //then
        assertEquals(historyModel.getFormula(), calculatorManager.removeSpaces(input));
        assertEquals(historyModel.getAnswer(), output);
    }

    @ParameterizedTest
    @CsvSource(value = {"7 * 3 : 21", "1 * 2 : 2", "5 * 7 * 10 : 350"}, delimiter = ':')
    @DisplayName("CalculatorService.calculate(String) - 곱셈 연산 테스트")
    void 곱셈(String input, String output) {
        HistoryModel historyModel = calculatorService.calculate(input);
        assertEquals(historyModel.getFormula(), calculatorManager.removeSpaces(input));
        assertEquals(historyModel.getAnswer(), output);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 / 2 : 5", "100 / 2 : 50", "20 / 2 / 5 : 2"}, delimiter = ':')
    @DisplayName("CalculatorService.calculate(String) - 나눗셈 연산 테스트")
    void 나눗셈(String input, String output) {
        HistoryModel historyModel = calculatorService.calculate(input);
        assertEquals(historyModel.getFormula(), calculatorManager.removeSpaces(input));
        assertEquals(historyModel.getAnswer(), output);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 * 5 / 4 + 7 * 2 : 19", "10 + 5 * 3 / 3 : 15", "15 * 2 - 17 : 13", "3+2+2*3+2*3 : 17"}, delimiter = ':')
    @DisplayName("CalculatorService.calculate(String) - 사칙 연산 테스트")
    void 사칙연산(String input, String output) {
        HistoryModel historyModel = calculatorService.calculate(input);
        assertEquals(historyModel.getFormula(), calculatorManager.removeSpaces(input));
        assertEquals(historyModel.getAnswer(), output);
    }
}
