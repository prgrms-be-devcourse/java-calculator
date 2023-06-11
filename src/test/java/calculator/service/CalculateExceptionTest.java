package calculator.service;

import calculator.domain.repository.CalculatorRepository;
import calculator.error.exception.DivisionByZeroException;
import calculator.error.exception.WrongInputFormulaException;
import calculator.error.model.ResponseErrorFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateExceptionTest {

    private CalculatorManager calculatorManager;
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorManager = new CalculatorManager();
        calculatorService = new CalculatorService(new CalculatorRepository(), calculatorManager);
    }

    @ParameterizedTest
    @CsvSource(value = {"4*5/4+", "/15*2", "//5"})
    @DisplayName("CalculatorManager.isCorrectFormula(String) - 연산식이 잘못 되었을 때, - WrongInputFormulaException")
    void 잘못된_연산식(String input) {
        assertThatThrownBy(() -> calculatorManager.isCorrectFormula(input))
                .isInstanceOf(WrongInputFormulaException.class)
                .hasMessageContaining(ResponseErrorFormat.FAIL_WRONG_INPUT_FORMULA.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"5/0", "1+2/0", "5*1/0"})
    @DisplayName("CalculatorService.calculate(String) - 0으로 나눴을 때, - DivisionByZeroException")
    void 제로_나눗셈(String input) {
        assertThatThrownBy(() -> calculatorService.calculate(input))
                .isInstanceOf(DivisionByZeroException.class)
                .hasMessageContaining(ResponseErrorFormat.FAIL_DIVISION_BY_ZERO.getMessage());
    }
}
