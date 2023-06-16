package test.calculator.calculation;

import com.calculator.calculation.PostfixCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    public void testPostfixCalculation(){
        PostfixCalculator postfixCalculator = new PostfixCalculator();
        ArrayList<String> postfix = new ArrayList<>(Arrays.asList("1", "2", "3", "*", "+"));

        int expectedValue = 7;
        int actualValue = postfixCalculator.calculatePostfix(postfix);

        assertEquals(expectedValue, actualValue);
    }
}

