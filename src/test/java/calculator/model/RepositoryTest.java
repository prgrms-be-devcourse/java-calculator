package calculator.model;

import com.programmers.java.calculator.model.ExpressionRepository;
import com.programmers.java.calculator.model.MemoryExpressionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTest {
    private final ExpressionRepository expressionRepository = new MemoryExpressionRepository();

    @Test
    @DisplayName("Repository에 저장된 특정 계산 결과 가져오기")
    public void findById() {
        expressionRepository.save("5 * 3 - 11 + 4", "8");
        assertThat(expressionRepository.findById("5 * 3 - 11 + 4")).isEqualTo("5 * 3 - 11 + 4 = 8");
    }

    @Test
    @DisplayName("Repository에 저장된 모든 데이터 불러오기")
    public void findAll() {
        expressionRepository.save("11 + 11 - 11 * 11 / 11", "11");
        expressionRepository.save("-4.53 + 10.21 * 1.23", "8.03");

        assertThat(expressionRepository.findAll()).containsExactly(
                "11 + 11 - 11 * 11 / 11 = 11",
                "-4.53 + 10.21 * 1.23 = 8.03"
        );
    }

    @Test
    @DisplayName("데이터 저장 여부 확인하기")
    public void save() {
        assertThat(expressionRepository.save("11 + 11 - 11 * 11 / 11", "11")).isEqualTo(true);
    }

    @Test
    @DisplayName("중복 데이터 캐시 여부 확인하기")
    public void cached() {
        expressionRepository.save("11 + 11 - 11 * 11 / 11", "11");
        assertThat(expressionRepository.cached("11 + 11 - 11 * 11 / 11")).isEqualTo(true);
    }
}
