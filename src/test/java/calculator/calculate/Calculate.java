package calculator.calculate;

import calculator.io.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculate {

    Calculation calculation;

    @Test
    void 더하기(){
        calculation = new CalculationImpl();
        String[] testString = {
                "1 + 5",
                "2 + 3 + 4 + 30 + 100",
                "0.5 + 0.2"
        };
        String result = calculation.calculate(testString[0]);
        Assertions.assertEquals("6.0",result);
        result = calculation.calculate(testString[1]);
        Assertions.assertEquals("139.0",result);
        result = calculation.calculate(testString[2]);
        Assertions.assertEquals("0.7",result);

    }

    /**
     * 스택으로 구현시 빼기에서 문제가 생김. ( 뒤에서 부터 계산하다 보니 )
     * -> ArrayList
     */
    @Test
    void 빼기(){
        calculation = new CalculationImpl();
        String[] testString = {
                "1 - 5",
                "2 + 3 - 4 - 30 - 100",
                "0.2 - 0.5"
        };
        String result = calculation.calculate(testString[0]);
        Assertions.assertEquals("-4.0",result);
        result = calculation.calculate(testString[1]);
        Assertions.assertEquals("-129.0",result);
        result = calculation.calculate(testString[2]);
        Assertions.assertEquals("-0.3",result);

    }
    @Test
    void 곱하기(){
        calculation = new CalculationImpl();
        String[] testString = {
                "1 * 5",
                "2 * 30 - 100",
                "0.3 * 0.5"
        };
        String result = calculation.calculate(testString[0]);
        Assertions.assertEquals("5.0",result);
        result = calculation.calculate(testString[1]);
        Assertions.assertEquals("-40.0",result);
        result = calculation.calculate(testString[2]);
        Assertions.assertEquals("0.15",result);
    }
    @Test
    void 나누기(){
        calculation = new CalculationImpl();
        String[] testString = {
                "1 / 5",
                "2 + 30 / 100",
                "0.3 / 0.5"
        };
        String result = calculation.calculate(testString[0]);
        Assertions.assertEquals("0.2",result);
        result = calculation.calculate(testString[1]);
        Assertions.assertEquals("2.3",result);
        result = calculation.calculate(testString[2]);
        Assertions.assertEquals("0.6",result);
    }
    @Test
    void 계산불가능(){
        calculation = new CalculationImpl();
        String[] testString={
                "",
                "    ",
                "- 3",
                "2 + 4 - 5 - -",
                "5 1",
                "9 +1",
                "10 +2/"
        };
        Arrays.stream(testString).forEach(s -> {
            String result = calculation.calculate(s);
            Assertions.assertEquals(Message.CALCULATE_ERROR_MESSAGE.getMessage(),result);
        });
    }
    @Test
    void 영으로나누는경우(){
        calculation = new CalculationImpl();
        String[] testString={
                "3 / 0",
                "2 / 4 / 0 - -",
                "0 / 0"
        };
        Arrays.stream(testString).forEach(s -> {
            String result = calculation.calculate(s);
            Assertions.assertEquals(Message.CALCULATE_ERROR_MESSAGE.getMessage(),result);
        });
    }

}
