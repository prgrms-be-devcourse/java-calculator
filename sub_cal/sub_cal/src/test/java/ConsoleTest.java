import model.Calculator;
import model.History;
import model.Operator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    static Calculator cal;

    @BeforeAll
    static void beforeAll() {
        cal = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("결과값 확인")
    @CsvSource(value = {"1 + 3,4","1 * 3 + 6,9","1 + 3 * 9 - 7 * 8 * 2 / 8,14","1 + 2 - 1 * 3 - 2,-2"})
    public void input(String input,int expected) {

        int result;
        result = cal.cal(input);
        assertEquals(expected,result);

    }


}
