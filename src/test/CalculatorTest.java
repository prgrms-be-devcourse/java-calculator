import main.java.domain.Command;
import main.java.service.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    static Calculator calculator;
    @BeforeAll
    public static void setting() {
        calculator = new Calculator();
    }

    @DisplayName("calculate함수는 띄어쓰기로 파싱된 input을 계산하는 함수.")
    @ParameterizedTest
    @CsvSource({"5 * 2 + 64 / 32 - 7, 5",
            "15 / 5 * 2 + 8 / 2, 10",
            "2 + 12 / 6 - 3 * 7, -17",
            "7 - 25 * 3 + 20 / 10, -66"
    })
    // Test는 하나의 시나리오에 대해서만 검증하도록.
    void calculateTest(String input, int expected) {
        Command command = new Command(input.split(" "));
        assertEquals(expected, calculator.calculate(command));
    }
}
