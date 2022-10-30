package calculator.service;

import calculator.domain.*;
import calculator.exception.DividedByZeroException;
import calculator.exception.InvalidOperatorException;
import calculator.repository.CalculatorRepository;
import calculator.repository.MapCalculatorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTest {

    CalculatorRepository calculatorRepository;
    Calculator calculator;
    CalculatorService calculatorService;

    @BeforeEach
    void set(){
        calculatorRepository = new MapCalculatorRepository();
        calculator = new BaseCalculator(calculatorRepository);
        calculatorService = new CalculatorService(calculator);
    }

    @Test
    @DisplayName("[성공] 모든 계산 이력 조회하기")
    void getAllData() {
        //given
        String EXPRESSION = "1+1";
        String ANSWER = "2";
        String CALCULATION_RESULT = "1+1 = 2\n";

        calculatorRepository.save(new CalculationResultHistory(EXPRESSION, ANSWER));

        //when
        String answer = calculatorService.getAllData();

        //then
        Assertions.assertThat(CALCULATION_RESULT).isEqualTo(answer);
    }

    @Test
    @DisplayName("[성공] 모든 계산 이력 조회하기 - 조회할 내용이 없는 경우")
    void getAllData_Empty() {
        //given
        String GETALLDATA_NO_DATA_TO_GET = "> 조회할 데이터가 없습니다";

        //when
        String answer = calculatorService.getAllData();

        //then
        Assertions.assertThat(GETALLDATA_NO_DATA_TO_GET).isEqualTo(answer);
    }

    @Test
    @DisplayName("[성공] 계산하기")
    void calculate() {
        //given
        String EXP_OF_ADD_N_MIN = "1 + 1 - 5";
        String ANSWER_OF_ADD_N_MIN = "-3";

        //when
        String answer = calculatorService.calculate(EXP_OF_ADD_N_MIN);

        //then
        Assertions.assertThat(ANSWER_OF_ADD_N_MIN).isEqualTo(answer);
    }

    @Test
    @DisplayName("[실패] 계산하기 - 지정된 연산자가 없을 경우")
    void calculate_invalid_operator() {
        //given
        String EXP_OF_INVALID_OPR = "2 ! 0";

        //when then
        assertThrows(InvalidOperatorException.class, () -> {
            calculatorService.calculate(EXP_OF_INVALID_OPR);
        });
    }

    @Test
    @DisplayName("[실패] 계산하기 - 0으로 나누는 경우")
    void calculate_divided_by_0() {
        //given
        String EXP_OF_DIV_BY_0 = "2 / 0";

        //when then
        assertThrows(DividedByZeroException.class, () -> {
            calculatorService.calculate(EXP_OF_DIV_BY_0);
        });
    }

    @Test
    @DisplayName("[성공] 종료하기")
    void exit() {
        //given
        String EXIT_PROGRAM = "> 계산기 프로젝트를 종료합니다";

        //when
        String answer = calculatorService.exit();

        //then
        Assertions.assertThat(EXIT_PROGRAM).isEqualTo(answer);
    }
}
