package calculator.repository;

import calculator.domain.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorRepositoryTest {
    private static CalculatorRepository calculatorRepository;
    @BeforeAll
    static void initRepository() {
        calculatorRepository = new CalculatorRepository();
    }

    @Test
    void 계산식저장소에서_계산식리스트를_반환() {
        assertThat(calculatorRepository.findAll()).isInstanceOf(ArrayList.class);
    }

    @Test
    void 계산식저장소에_Calculator_저장() {
        Calculator calculator = new Calculator("1 + 2 + 3", 6);
        assertThat(calculatorRepository.add(calculator)).isEqualTo(true);

        List<Calculator> c = calculatorRepository.findAll();
        assertThat(c.get(0)).isEqualTo(calculator);
    }
}
