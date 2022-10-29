package calculator.service;

import calculator.domain.*;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;
import calculator.io.Input;
import calculator.io.Output;
import calculator.repository.MapCalculatorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static calculator.domain.Command.*;

public class BaseCalculatorServiceTest {

    private static int LEN_OF_INTRO() {
        String introduction = "\n\n";
        for (Command c : Command.values()) {
            introduction = introduction.concat(c.getCode() + ". " + c.getCommand() + "\n");
        }
        return introduction.length();
    }

    private static final int LEN_OF_CMD = "선택 : n\n".length();

    @Test
    @DisplayName("[성공] 모든 계산 이력 조회하기")
    void getAllData() {
        //given
        String EXPRESSION = "1+1";
        String CALCULATION_RESULT = "1+1 = 2";

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));
        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        calculator.calculate(EXPRESSION);

        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + CALCULATION_RESULT.length() + 2).trim();
        Assertions.assertThat(CALCULATION_RESULT).isEqualTo(answer);
    }

    @Test
    @DisplayName("[성공] 모든 계산 이력 조회하기 - 조회할 내용이 없는 경우")
    void getAllData_Empty() {
        //given
        String GETALLDATA_NO_DATA_TO_GET = "> 조회할 데이터가 없습니다";

        System.setIn(new ByteArrayInputStream((GETALLDATA.getCode() + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + GETALLDATA_NO_DATA_TO_GET.length() + 2).trim();
        Assertions.assertThat(GETALLDATA_NO_DATA_TO_GET).isEqualTo(answer);
    }

    @Test
    @DisplayName("[성공] 계산하기")
    void calculate() {
        //given
        String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
        String ANSWER_OF_ADD_N_MIN = "-3";

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_ADD_N_MIN + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + 4).trim();
        Assertions.assertThat(ANSWER_OF_ADD_N_MIN).isEqualTo(answer);
    }

    @Test
    @DisplayName("[실패] 계산하기 - 지정된 연산자가 없을 경우")
    void calculate_invalid_operator() {
        //given
        String EXP_OF_DIV_BY_0 = "2 ! 0";
        String CALCULATE_WITH_INVALID_OPERATOR = "> 존재하지 않는 연산자입니다";
        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_DIV_BY_0 + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + CALCULATE_WITH_INVALID_OPERATOR.length() + 2).trim();
        Assertions.assertThat(CALCULATE_WITH_INVALID_OPERATOR).isEqualTo(answer);
    }

    @Test
    @DisplayName("[실패] 계산하기 - 0으로 나누는 경우")
    void calculate_divided_by_0() {
        //given
        String EXP_OF_DIV_BY_0 = "2 / 0";
        String CALCULATE_DIV_BY_0 = "> 0으로 나눌 수 없습니다";

        System.setIn(new ByteArrayInputStream((CALCULATE.getCode() + "\n" + EXP_OF_DIV_BY_0 + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD, LEN_OF_INTRO() + LEN_OF_CMD + CALCULATE_DIV_BY_0.length() + 2).trim();
        Assertions.assertThat(CALCULATE_DIV_BY_0).isEqualTo(answer);
    }

    @Test
    @DisplayName("[성공] 종료하기")
    void exit() {
        //given
        String EXIT_PROGRAM = "> 계산기 프로젝트를 종료합니다";

        System.setIn(new ByteArrayInputStream((EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO() + LEN_OF_CMD).trim();
        Assertions.assertThat(EXIT_PROGRAM).isEqualTo(answer);
    }

    @Test
    @DisplayName("[실패] 존재하지 않는 명령어")
    void wrong_command() {
        //given
        String wrongCommand = "5";
        String WRONG_COMMAND = "> 존재하지 않는 명령어입니다";

        System.setIn(new ByteArrayInputStream((wrongCommand + "\n" + EXIT.getCode() + "\n").getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Input input = new ConsoleInput(new BufferedReader(new InputStreamReader(System.in)));
        Output output = new ConsoleOutput(new BufferedWriter(new OutputStreamWriter(System.out)));

        Calculator calculator = new BaseCalculator(new MapCalculatorRepository());
        CalculatorService calculatorService = new CalculatorService(calculator, input, output);

        //when
        calculatorService.run();

        //then
        String answer = out.toString().substring(LEN_OF_INTRO(), LEN_OF_INTRO() + WRONG_COMMAND.length() + 2).trim();
        Assertions.assertThat(WRONG_COMMAND).isEqualTo(answer);
    }
}
