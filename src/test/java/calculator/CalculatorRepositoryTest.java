package calculator;

import calculator.repository.CalculatorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorRepositoryTest {
    private CalculatorRepository repository = new CalculatorRepository();

    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    @DisplayName("리포지토리 저장 & 조회 테스트")
    void test_01() throws Exception {
        String empty = repository.search();
        assertThat(empty).contains("데이터가 존재하지 않습니다.");

        String formula1 = "1 + 2 + 3";
        String formula2 = "2 + 3 + 4";
        String formula3 = "3 + 4 + 5";
        String answer1 = "6";
        String answer2 = "9";
        String answer3 = "12";

        repository.save(formula1, answer1);
        repository.save(formula2, answer2);
        repository.save(formula3, answer3);

        Map<String, String> storage = repository.getStorage();
        assertThat(storage).isNotNull();
        assertThat(storage.size()).isEqualTo(3);
        assertThat(storage).extractingByKey(formula1).isEqualTo(answer1);

        String search = repository.search();
        String result1 = formula1 + " = " + answer1;
        String result2 = formula2 + " = " + answer2;
        String result3 = formula3 + " = " + answer3;

        assertThat(search).contains(result1, result2, result3);
    }
}