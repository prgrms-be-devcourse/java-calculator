package service;

import com.programmers.error.CalculatorException;
import com.programmers.repository.CalculatorRepository;
import com.programmers.repository.MapCalculatorRepository;
import com.programmers.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.programmers.error.ErrorMessage.DIVIDE_ZERO_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;
    private CalculatorRepository calculatorRepository;

    @BeforeEach
    void beforeEach() {
        calculatorRepository = new MapCalculatorRepository();
        calculatorService = new CalculatorService(calculatorRepository);
    }

    @DisplayName("식 입력 시 계산 성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 + 5 / 4:4", "3 + 4 + 3:10"}, delimiter = ':')
    void 식_계산_테스트(String expression, String result) {
        String output = String.valueOf(calculatorService.calculate(expression));
        assertEquals(result, output);
    }

    @DisplayName("[실패]식 입력 시 계산 실패 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 + 5 / 0"})
    void 식_계산_실패_테스트(String expression) {
        assertThatThrownBy(() -> calculatorService.calculate(expression))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining(DIVIDE_ZERO_EXCEPTION.getMessage());
    }
}
