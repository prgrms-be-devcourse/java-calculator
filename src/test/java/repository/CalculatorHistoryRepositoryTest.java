package repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorHistoryRepositoryTest {

    private final CalculatorHistoryRepository repository = new CalculatorHistoryRepository();

    @Test
    @DisplayName("값 저장 및 출력 테스트")
    void saveInRepositoryTest() {
        repository.save("1+2", 3);
        repository.save("1*3", 3);
        repository.save("3+(4*8)", 35);
    }
}