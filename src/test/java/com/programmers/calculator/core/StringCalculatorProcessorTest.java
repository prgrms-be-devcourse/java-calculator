package com.programmers.calculator.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("StringCalculatorProcessor 테스트")
class StringCalculatorProcessorTest {

    private final CalculatorProcessor calculatorProcessor = new StringCalculatorProcessor();

    @DisplayName("calculate() 테스트 - 나눗셈과 곱셉이 없는 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 1 + 1, 3",
            "3 - 3 - 3, -3",
            "9 - 5 + 30, 34"})
    void calculateTestWithOutDivisionAndMultiplication(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 모든 연산 테스트")
    @CsvSource(value = {
            "1 / 1 * 1, 1",
            "10 - 3 * 5, -5",
            "100 * 10 - 5 - 5 * 10 , 945"})
    @ParameterizedTest
    void calculateAllTest(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 곱셉만 있는 테스트")
    @CsvSource(value = {
            "3 * 3 * 3 * 3, 81",
            "10 * 10 * 10, 1000",
            "10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1, 3628800"})
    @ParameterizedTest
    void calculatorTestOnlyMultiply(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 덧셈만 있는 테스트")
    @CsvSource(value = {
            "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10, 55",
            "123 + 123 + 123, 369",
            "1000 + 10000 + 100000, 111000"
    })
    @ParameterizedTest
    void calculatorTestOnlyAdd(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 뺄셈만 있는 테스트")
    @CsvSource(value = {
            "10 - 9 - 8 - 7 - 6 - 5 - 4 - 3 - 2 - 1, -35",
            "1000 - 900 - 100, 0",
            "999 - 99 - 900, 0"
    })
    @ParameterizedTest
    void calculatorTestOnlySubtract(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 나눗셈만 있는 테스트")
    @CsvSource(value = {
            "10 / 10 / 10 / 10 / 10, 0.001",
            "-35 / -35, 1",
            "-100 / 1, -100",
            "100 / -1, -100"
    })
    @ParameterizedTest
    void calculatorTestOnlyDivide(String expressionStr, double expectedResult) {
        //given
        Expression expression = new Expression(expressionStr);

        //when
        Number calculateResult = calculatorProcessor.calculate(expression);

        //then
        assertEquals(expectedResult, calculateResult);
    }

}