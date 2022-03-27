import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    String operation;

    @Test
    void testCalculate(){
        operation= "2+3*7-6";
        Number result = calculator.calculate(operation);
        // Assertions.assertEquals(result, 17);
    }

}
