package com.programmers.calculator.service;

import com.programmers.calculator.controller.io.Response;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.InMemoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("CalculatorServiceTest")
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    private InMemoryRepository inMemoryRepository;

    @BeforeEach
    void setUp() {
        inMemoryRepository = new InMemoryRepository();
        calculatorService = new CalculatorService(inMemoryRepository);
    }

    @DisplayName("연산 테스트 - 연산을 하면 연산결과를 반환하고 Repository에 저장된다.")
    @Test
    void processTestReturnResultAndSaveRepository() {
        //given
        String expressionStr = "1 + 1 + 1";
        Number result = 3;
        Expression expression = new Expression(expressionStr);

        //when
        Response process = calculatorService.process(expression);
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();

        //then
        assertEquals(result.toString(), process.result());
        assertNotEquals(0, calculateHistories.size());
        assertEquals(1, calculateHistories.size());
        CalculateHistory calculateHistory = calculateHistories.get(0);
        assertEquals(expressionStr + " = " + result,calculateHistory.getHistory());
    }

    @DisplayName("조회 테스트 - 모든 연산 결과 순서대로 반환")
    @Test
    void findAllOrderById() {
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
        Response response = calculatorService.findAllOrderById();

        //then
        assertEquals(
                calculateResult1 + "\n" +
                        calculateResult2 + "\n" +
                        calculateResult3,
                response.result());
    }

    @DisplayName("조회 테스트 - 저장된 데이터 없을 시 저장된 데이터가 없습니다. 반환")
    @Test
    void findAllNotData() {
        // given & when
        Response response = calculatorService.findAllOrderById();

        //then
        assertEquals("저장된 데이터가 없습니다.", response.result());
    }

}