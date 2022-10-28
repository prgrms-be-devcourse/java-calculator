package calculator.service;

import calculator.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.domain.Command.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseCalculatorServiceTest {

    public static int LEN_OF_INTRO_N_CMD() {
        String introduction = "\n\n" + "선택 : n\n";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction.length();
    }


    @Test
    void getAllData() {
        List<String> LIST_OF_DATA = Arrays.asList("1+1=2", "2+2=4", "3+3=6");
        String STRING_OF_DATA = "1+1=2" + "\n" + "2+2=4" + "\n" + "3+3=6" + "\n";

        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.getAllData()).thenReturn(LIST_OF_DATA);

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + STRING_OF_DATA.length() + 2).trim();
        Assertions.assertThat(STRING_OF_DATA.trim()).isEqualTo(answer);
    }

    @Test
    void getAllData_Empty() {
        List<String> EMPTY_LIST_OF_DATA = new ArrayList<>();
        String GETALLDATA_NO_DATA_TO_GET = "> 조회할 데이터가 없습니다";

        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.getAllData()).thenReturn(EMPTY_LIST_OF_DATA);

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + GETALLDATA_NO_DATA_TO_GET.length() + 2).trim();
        Assertions.assertThat(GETALLDATA_NO_DATA_TO_GET).isEqualTo(answer);
    }

    @Test
    void calculate() {
        String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
        String ANSWER_OF_ADD_N_MIN = "-3";
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.calculate(EXP_OF_ADD_N_MIN)).thenReturn(ANSWER_OF_ADD_N_MIN);
        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_ADD_N_MIN + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + 4).trim();
        Assertions.assertThat(String.valueOf(ANSWER_OF_ADD_N_MIN)).isEqualTo(answer);
    }

    @Test
    void calculate_divided_by_0() {
        String EXP_OF_DIV_BY_0 = "2 / 0";
        String CALCULATE_DIV_BY_0 = "> 0으로 나눌 수 없습니다. 다시 입력해주세요";
        Calculator calculator = mock(BaseCalculator.class);
        when(calculator.calculate(EXP_OF_DIV_BY_0)).thenThrow(ArithmeticException.class);

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_DIV_BY_0 + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + CALCULATE_DIV_BY_0.length() + 2).trim();
        Assertions.assertThat(CALCULATE_DIV_BY_0).isEqualTo(answer);
    }

    @Test
    void exit() {
        String EXIT_PROGRAM = "> 계산기 프로젝트를 종료합니다";
        Calculator calculator = mock(BaseCalculator.class);

        System.setIn(new ByteArrayInputStream((EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD()).trim();
        Assertions.assertThat(EXIT_PROGRAM).isEqualTo(answer);
    }

    @Test
    void wrong_command() {
        String wrongCommand = "5";
        String WRONG_COMMAND = "> 다시 입력해주세요";

        Calculator calculator = mock(BaseCalculator.class);

        System.setIn(new ByteArrayInputStream((wrongCommand + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO_N_CMD(), LEN_OF_INTRO_N_CMD() + WRONG_COMMAND.length() + 2).trim();
        Assertions.assertThat(WRONG_COMMAND).isEqualTo(answer);
    }
}
