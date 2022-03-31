package calculator.repository;

import calculator.io.Console;
import calculator.io.Output;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class MemoryExpressRepositoryTest {
    ExpressRepository repository;
    Output output;

    @BeforeEach
    void beforeEach() {
        output = new Console();
        repository = new MemoryExpressRepository();
        repository.save("3 + 3", 6);
        repository.save("3 * 10", 30);
        repository.save("3 / 3", 1);
        repository.save("2-4", -2);
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


    @DisplayName("히스토리 출력 테스트")
    @Test
    void validHistoryPrint() {
        final String want =
                "3 + 3=6\n" +
                "3 * 10=30\n" +
                "3 / 3=1\n" +
                "2-4=-2\n";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        repository.historyPrint(output);

        Assertions.assertThat(out.toString()).isEqualTo(want);
    }
}