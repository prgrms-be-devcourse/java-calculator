import engine.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorExceptionTest {
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.calculator = appConfig.calculator();
    }

    /**  ArithmeticException test  **/
    @Test
    public void ArithmeticExceptionThrownTest() throws Exception {

        //given
        String input = "2 / 0";
        Exception exception = assertThrows(ArithmeticException.class,
                () -> {
                    String result = calculator.cal(input);
                });
    }


    /** IllegalArgumentException test  **/
    @Test
    public void exceptionThrownTest() throws Exception {

        String input = "8 ) 0";

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    String result = calculator.cal(input);
                });
    }
}
