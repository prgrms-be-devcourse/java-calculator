package calculator.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemoryResultRepositoryTest {

    MemoryResultRepository repository = new MemoryResultRepository();

    @BeforeEach
    void setup() {
        repository.save("1 + 2 = 3");
        repository.save("4 * 3 = 12");
        repository.save("1 + 2 / 2 = 2");
    }

    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @DisplayName("문자열을 주면 그 값을 저장한다.")
    @Test
    void save_result() {
        String expected = "1 + 2 = 3";
        repository.save(expected);

        assertThat(repository.findAll().get(3)).isEqualTo("1 + 2 = 3");
    }

    @DisplayName("결과 전체를 반환한다.")
    @Test
    void find_All() {
        List<String> results = repository.findAll();
        assertThat(results.size()).isEqualTo(3);
        assertThat(results).contains("1 + 2 = 3", "4 * 3 = 12", "1 + 2 / 2 = 2");
    }
}
