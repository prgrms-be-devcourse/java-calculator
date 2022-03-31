package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        calculator = new Calculator(appConfig.input(), appConfig.output(),
                appConfig.parser(), appConfig.calculate(), appConfig.expressRepository());
        calculator.execute("5 + 7");
        calculator.execute("5 - 7");
        calculator.execute("5 * 7");
        calculator.execute("15 / 7");
    }

    @AfterEach
    void afterEach() {
        calculator.repository.clearStore();
    }

    @DisplayName("계산기 계산 테스트")
    @Test
    void calculatorCalculateTest() {
        int want = 7;
        int got = calculator.execute("3 + 4");

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("계산기 히스토리 테스트")
    @Test
    void calculatorHistoryTest() {
        String want = "5+7=12\n" +
                "5-7=-2\n" +
                "5*7=35\n" +
                "15/7=2\n";
        OutputStream got = new ByteArrayOutputStream();
        System.setOut(new PrintStream(got));

        calculator.history();

        Assertions.assertThat(got.toString()).isEqualTo(want);
    }
}
