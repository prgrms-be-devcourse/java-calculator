import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CalculatorTest {

    String operation;
    Calculator calculator = new Calculator();

    @Test
    void testCalculate() {
        operation = "2+3*7-6/2*2+3-5";  //2 + 21 -6 +3 -5 = 23 17 20 15
        double expect = 2+3*7-6/2*2+3-5;
        Number result = calculator.calculate(operation);
        Assertions.assertEquals(result, expect);
    }


}
