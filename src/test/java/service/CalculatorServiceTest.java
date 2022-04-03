package service;

import entity.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import repository.CalculatorMemoryRepository;
import repository.CalculatorRepository;

import static org.assertj.core.api.Assertions.*;


public class CalculatorServiceTest {
    CalculatorRepository calculatorRepository = new CalculatorMemoryRepository();
    CalculatorService calculatorService = new CalculatorService(calculatorRepository);

    @ParameterizedTest
    @DisplayName("계산식 연산 후 결과 출력 테스트")
    @CsvSource({
            "1 + 3 + 4, 8.0",
            "2 * 2 * 2, 8.0",
            "2 / 2 / 2, 0.5",
            "1 - 1 - 1, -1.0",
            "2 + 2 * 4 - 1 * 10 / 5, 8.0"
    })
    void calculate(String formula, String result) {
        assertThat(calculatorService.calculate(formula)).isEqualTo(result);
    }

    @Test
    @DisplayName("전체 조회 테스트")
    void showAllResult() {
        for (Long id = 0L; id < 10; id++) {
            Data data = new Data(id, "formula" + id, "result" + id);
            calculatorService.saveResult(data);
        }

        calculatorService.showAllResult();
    }
}