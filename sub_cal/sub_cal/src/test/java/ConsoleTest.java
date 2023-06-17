import model.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("결과값 확인")
    @CsvSource(value = {"1 + 3,4","1 * 3 + 6,9","1 + 3 * 9 - 7 * 8 * 2 / 8,14","1 + 2 - 1 * 3 - 2,-2"})
    public void input(String input,String expected) {

        String result;
        result = calculator.calculate(input);
        assertEquals(expected,result);

    }


}
