package calculator;

import calculator.model.calculator.PostfixCalculator;
import calculator.repository.CalculationRepository;
import calculator.model.converter.InfixToPostfixConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class CalculatorTest {

    private final static ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;
    private final InputStream systemIn = System.in;


    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams(){
        System.setOut(System.out);
        System.setIn(systemIn);
    }

    @Test
    @DisplayName("계산기 통합 테스트")
    void 계산기통합테스트_계산하기() { // fail
        String[] inputs = { "2", "3 + 5 * -1", "2", "-1 * 2 + 5 - 1", "1", "0"};
        InputStream in = new ByteArrayInputStream(String.join("\r\n", inputs).getBytes());
        System.setIn(in);

        CalculatorConsole console = new CalculatorConsole();
        new Calculator(
                new PostfixCalculator(),
                new InfixToPostfixConverter(),
                console,
                console,
                new CalculationRepository()
        ).run();

        String output = outputMessage.toString();
        System.out.println("output = " + output);
    }
}