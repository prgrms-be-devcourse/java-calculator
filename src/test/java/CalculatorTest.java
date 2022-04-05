import engine.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.calculator = appConfig.calculator();
    }

    @Test
    public void calculateTest() throws Exception {

        //given
        String input = "2 + 3 * 8 / 2";
        String valueExpected="14.00";

        //when
        String result=calculator.cal(input);

        //then
        assertEquals(valueExpected, result);

    }
}
