import org.junit.jupiter.api.Test;
//import Calculator;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculateTest() {
        Calculator calculator = Calculator.getInstance();
        String command = "1 + 2 * 23 - 32";
        String[] commandArr = command.split(" ");
        int result = calculator.calculate(commandArr);
        assertEquals(15, result);
    }
}