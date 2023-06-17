package calculator.service;

import calculator.domain.Calculator;
import calculator.repository.CalculatorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.model.CalculateRequest;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {
    private static CalculatorRepository calculatorRepository;
    private static CalculatorService calculatorService;
    @BeforeAll
    static void initRepository() {
        calculatorRepository = new CalculatorRepository();
        calculatorService = new CalculatorService(calculatorRepository);

        calculatorRepository.add(new Calculator("1 + 2 + 3", 6));
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 + 3 / 3 * 4 * ( 5 + 6 ), 45"
            ,"1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 / 2 + 1 / 2 + 8 / 4 * 2, 5"
            ,"3 / 4 - 1 / 4, 0.5"
    })
    void 계산식_통합_test(String userInput, double result) {
        CalculateRequest calculateRequest = new CalculateRequest(userInput);
        assertThat(result).isEqualTo(calculatorService.calculate(calculateRequest));
    }



    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 + 3 / 3 * 4 * ( 5 + 6 ), 45"
            ,"1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 / 2 + 1 / 2 + 8 / 4 * 2, 5"
            ,"3 / 4 - 1 / 4, 0.5"
    })
    void 저장소에_데이터추가_확인_test(String userInput, double result) {
        String make = userInput+" = "+result;
        CalculateRequest calculateRequest = new CalculateRequest(userInput);
        calculatorService.calculate(calculateRequest);

        assertThat(calculatorService.getCalculateResults().stream()
                .anyMatch(calc -> make.equals(calc)))
                .isTrue();
    }
}
