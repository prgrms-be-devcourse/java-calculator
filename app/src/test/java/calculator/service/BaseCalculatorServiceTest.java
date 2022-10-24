package calculator.service;

import calculator.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static calculator.Fixture.*;
import static calculator.domain.Command.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseCalculatorServiceTest {

    @Test
    void getAllData() {
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.getAllData()).thenReturn(LIST_OF_DATA());

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + STRING_OF_DATA.length() + 2).trim();
        Assertions.assertThat(STRING_OF_DATA.trim()).isEqualTo(answer);
    }

    @Test
    void getAllData_Empty() {
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.getAllData()).thenReturn(EMPTY_LIST_OF_DATA());

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + GETALLDATA_NO_DATA_TO_GET.length() + 2).trim();
        Assertions.assertThat(GETALLDATA_NO_DATA_TO_GET).isEqualTo(answer);
    }

    @Test
    void calculate() {
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.calculate(EXP_OF_ADD_N_MIN)).thenReturn(ANSWER_OF_ADD_N_MIN);
        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_ADD_N_MIN + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + 4).trim();
        Assertions.assertThat(String.valueOf(ANSWER_OF_ADD_N_MIN)).isEqualTo(answer);
    }

    @Test
    void calculate_divided_by_0() {
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.calculate(EXP_OF_DIV_BY_0)).thenThrow(ArithmeticException.class);

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_DIV_BY_0 + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + CALCULATE_DIV_BY_0.length() + 2).trim();
        Assertions.assertThat(CALCULATE_DIV_BY_0).isEqualTo(answer);
    }

    @Test
    void exit() {
        Calculator calculator = mock(BaseCalculator.class);

        System.setIn(new ByteArrayInputStream((EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD() + NEG_FOR_EXIT).trim();
        Assertions.assertThat(EXIT_PROGRAM).isEqualTo(answer);
    }

    @Test
    void wrong_command() {
        String wrongCommand = "5";
        Calculator calculator = mock(BaseCalculator.class);

        System.setIn(new ByteArrayInputStream((wrongCommand + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new BaseCalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + WRONG_COMMAND.length() + 2).trim();
        Assertions.assertThat(WRONG_COMMAND).isEqualTo(answer);
    }
}
