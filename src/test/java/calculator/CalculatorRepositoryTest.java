package calculator;

import calculator.repository.CalculatorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorRepositoryTest {
    private CalculatorRepository repository = new CalculatorRepository();

    String formula1 = "1 + 2 + 3";
    String formula2 = "2 + 3 + 4";
    String formula3 = "3 + 4 + 5";
    String answer1 = "6";
    String answer2 = "9";
    String answer3 = "12";

    @BeforeEach
    public void beforeEach() {
        repository.save(formula1, answer1);
        repository.save(formula2, answer2);
        repository.save(formula3, answer3);
    }

    @AfterEach
    public void afterEach() {
        repository.clear();
    }

    @Test
    @DisplayName("리포지토리 저장 테스트")
    void test_01() throws Exception {
        Map<String, String> storage = repository.getStorage();
        String randomFormula = "1 + 1 + 1";

        assertThat(storage.size()).isEqualTo(3); //테스트 코드가 실행되기 전에 beforeEach를 통해 3개의 계산을 저장했기 때문에 맵의 사이즈는 3개가 되어야 한다.
        assertThat(storage.get(formula2)).isEqualTo(answer2); //키 값으로 찾은 밸류와 정답의 값이 같아야 한다.
        assertThat(storage.get(randomFormula)).isNull(); //저장을 하지 않은 식이 들어오면 밸류 값은 null 이어야 한다.

        repository.clear();

        assertThat(storage.size()).isEqualTo(0); //저장소를 비우고 난 뒤 맵의 사이즈는 0이어야 한다.
    }

    @Test
    @DisplayName("리포지토리 조회 테스트")
    void test_02() throws Exception {
        String search = repository.search();
        String result1 = formula1 + " = " + answer1;
        String result2 = formula2 + " = " + answer2;
        String result3 = formula3 + " = " + answer3;

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(result1).append("\n");
        sb.append(result2).append("\n");
        sb.append(result3).append("\n");

        assertThat(search).isEqualTo(sb.toString()); //저장된 식과 값만 형식에 맞게 출력해야 한다.

        repository.clear();
        String empty = repository.search();
        assertThat(empty).containsOnlyOnce("데이터가 존재하지 않습니다."); //저장소가 비어있을 때 조회 시 해당 경고문을 리턴해야 한다.
    }
}