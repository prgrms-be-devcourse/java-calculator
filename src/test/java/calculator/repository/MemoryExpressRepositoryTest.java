package calculator.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class MemoryExpressRepositoryTest {
    ExpressRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryExpressRepository();
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @DisplayName("값 저장 테스트")
    @Test
    void validSaveTest() {
        String exp = "2 + 3";
        int answer = 5;

        repository.save(exp, answer);
        int ret = repository.findByExpress(exp);

        Assertions.assertThat(answer).isEqualTo(ret);
    }

}