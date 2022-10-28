package calculator.service;

import calculator.domain.*;
import calculator.repository.MapCalculatorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static calculator.domain.Command.*;

public class BaseCalculatorServiceTest {

    private static int LEN_OF_INTRO() {
        String introduction = "\n\n";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction.length();
    }

    int LEN_OF_CMD = "선택 : n\n".length();

    @Test
    void getAllData() {
        String EXPRESSION = "1+1";

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        calculator.calculate(EXPRESSION);

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + EXPRESSION.length() + 2).trim();
        Assertions.assertThat(EXPRESSION.trim()).isEqualTo(answer);
    }

    @Test
    void getAllData_Empty() {
        String GETALLDATA_NO_DATA_TO_GET = "> 조회할 데이터가 없습니다";

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + GETALLDATA_NO_DATA_TO_GET.length() + 2).trim();
        Assertions.assertThat(GETALLDATA_NO_DATA_TO_GET).isEqualTo(answer);
    }

    @Test
    void calculate() {
        String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
        String ANSWER_OF_ADD_N_MIN = "-3";
        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_ADD_N_MIN + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + 4).trim();
        Assertions.assertThat(String.valueOf(ANSWER_OF_ADD_N_MIN)).isEqualTo(answer);
    }

    @Test
    void calculate_divided_by_0() {
        String EXP_OF_DIV_BY_0 = "2 / 0";
        String CALCULATE_DIV_BY_0 = "> 0으로 나눌 수 없습니다";
        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_DIV_BY_0 + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + CALCULATE_DIV_BY_0.length() + 2).trim();
        Assertions.assertThat(CALCULATE_DIV_BY_0).isEqualTo(answer);
    }

    @Test
    void exit() {
        String EXIT_PROGRAM = "> 계산기 프로젝트를 종료합니다";
        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD).trim();
        Assertions.assertThat(EXIT_PROGRAM).isEqualTo(answer);
    }

    @Test
    void wrong_command() {
        String wrongCommand = "5";
        String WRONG_COMMAND = "> 존재하지 않는 명령어입니다";

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((wrongCommand + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculatorService calculatorService = new CalculatorService(calculator, System.in, System.out);
        calculatorService.run();

        String answer = out.toString().substring(LEN_OF_INTRO(), LEN_OF_INTRO() + WRONG_COMMAND.length() + 2).trim();
        Assertions.assertThat(WRONG_COMMAND).isEqualTo(answer);
    }
}
