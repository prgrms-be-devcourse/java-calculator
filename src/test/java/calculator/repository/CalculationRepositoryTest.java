package calculator.repository;

import calculator.model.calculator.CalculationResult;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CalculationRepositoryTest {

    private static CalculationRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new CalculationRepository();
    }

    @AfterEach
    void afterEach(){
        repository.clearStore();
    }

    @Test
    @DisplayName("CalculationRepository에 CaclulationResult가 잘 저장되었는지 확인하는 테스트")
    void save() {
        String expression = "3 + 5 * 2";
        Integer answer = 13;

        repository.save(new CalculationResult(expression, answer));

        List<String> results = repository.findAll().values().stream().map(CalculationResult::toString).toList();
        Assertions.assertThat(results)
                .hasSize(1)
                .contains("3 + 5 * 2 = 13", Index.atIndex(0));
    }

    @Test
    @DisplayName("Calculation Repository에서 CalculationResult 값들을 잘 가져오는지 확인하는 테스트")
    void findAll() {
        String expression1 = "3 + 5 * 2";
        Integer answer1 = 13;

        String expression2 = "5 - 1 * 2";
        Integer answer2 = 3;

        repository.save(new CalculationResult(expression1, answer1));
        repository.save(new CalculationResult(expression2, answer2));

        List<String> results = repository.findAll().values().stream().map(CalculationResult::toString).toList();
        assertEquals(2, results.size());
        Assertions.assertThat(results)
                .hasSize(2)
                .contains("3 + 5 * 2 = 13")
                .contains("5 - 1 * 2 = 3");

    }
}