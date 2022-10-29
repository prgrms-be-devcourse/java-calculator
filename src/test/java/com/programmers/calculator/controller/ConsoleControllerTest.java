package com.programmers.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.programmers.calculator.controller.io.ConsoleRequest;
import com.programmers.calculator.controller.io.ConsoleResponse;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.InMemoryRepository;
import com.programmers.calculator.service.CalculatorService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ConsoleController 테스트")
class ConsoleControllerTest {

    private ConsoleController consoleController;
    private InMemoryRepository inMemoryRepository;
    private CalculatorService calculatorService;

    @BeforeEach
    void beforeEach() {
        inMemoryRepository = new InMemoryRepository();
        calculatorService = new CalculatorService(inMemoryRepository);
        consoleController = new ConsoleController(calculatorService);
    }

    @DisplayName("조회 요청 테스트 - inquery() 호출시 계산식과 결과가 순서대로 정렬된 문자열을 반환한다")
    @Test
    void inquirySuccess() {
        //given
        String expressionStr1 = "1 + 1 + 1";
        String calculateResult1 = "1 + 1 + 1 = 3";
        String expressionStr2 = "2 * 2 * 2";
        String calculateResult2 = "2 * 2 * 2 = 8";
        String expressionStr3 = "3 * 3 / 3";
        String calculateResult3 = "3 * 3 / 3 = 3";

        calculatorService.process(new Expression(expressionStr1));
        calculatorService.process(new Expression(expressionStr2));
        calculatorService.process(new Expression(expressionStr3));

        //when
        ConsoleResponse response = consoleController.inquiry();

        //then
        assertEquals(
                calculateResult1 + "\n" +
                        calculateResult2 + "\n" +
                        calculateResult3,
                response.result());
    }

    @DisplayName("조회 요청 테스트 - inquery() 호출시 저장된 게산이력이 없다면 '저장된 데이터가 없습니다.'는 문자열을 반환한다.")
    @Test
    void inquiryReturnNoStoredDataMessage() {
        // given & when
        ConsoleResponse response = consoleController.inquiry();

        //then
        assertEquals("저장된 데이터가 없습니다.", response.result());
    }

    @DisplayName("연산 요청 테스트 - calculate() 연산 후 연산식과 결과 데이터를 저장하고 결과를 반환한다")
    @Test
    void calculateTest() {
        //given
        String expressionStr1 = "1 + 1 + 1";
        String result = "3";
        String calculateResult1 = "1 + 1 + 1 = 3";

        //when
        ConsoleResponse response = consoleController.calculate(new ConsoleRequest(expressionStr1));
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();

        //then
        assertEquals("3", response.result());
        CalculateHistory calculateHistory = calculateHistories.get(0);
        assertEquals(Double.valueOf(result), calculateHistory.getResult());
        assertEquals(calculateResult1, calculateHistory.getHistory());
    }

}