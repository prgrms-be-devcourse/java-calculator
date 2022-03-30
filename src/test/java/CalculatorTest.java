import engine.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

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


    /* IllegalArgumentException test */
    @Test
    public void exceptionThrownTest() throws Exception {

        String input = "8 ) 0";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    String result = calculator.cal(input);
                });
    }

}
