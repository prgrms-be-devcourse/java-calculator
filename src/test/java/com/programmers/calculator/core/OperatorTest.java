package com.programmers.calculator.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Operator enum 테스트")
class OperatorTest {

    @DisplayName("파라미터로 넘긴 문자열 연산자가 + 라면 OPERATOR.ADD를 리턴한다. ")
    @Test
    void findOperatorReturnAdd() {
        //given
        String operatorStr = "+";
        //when
        Operator operator = Operator.findOperator(operatorStr);

        //then
        assertEquals(Operator.ADD, operator);
    }

    @DisplayName("파라미터로 넘긴 문자열 연산자가 - 라면 OPERATOR.SUBTRACT를 리턴한다. ")
    @Test
    void findOperatorReturnSubtract() {
        //given
        String operatorStr = "-";
        //when
        Operator operator = Operator.findOperator(operatorStr);
        //then
        assertEquals(Operator.SUBTRACT, operator);

    }
    @DisplayName("파라미터로 넘긴 문자열 연산자가 * 라면 OPERATOR.MULTIPLY를 리턴한다. ")
    @Test
    void findOperatorReturnMultiply() {
        //given
        String operatorStr = "*";
        //when
        Operator operator = Operator.findOperator(operatorStr);
        //then
        assertEquals(Operator.MULTIPLY, operator);
    }

    @DisplayName("파라미터로 넘긴 문자열 연산자가  / 라면 OPERATOR.ADD를 리턴한다. ")
    @Test
    void findOperatorReturnDIVIDE() {
        //given
        String operatorStr = "/";
        //when
        Operator operator = Operator.findOperator(operatorStr);
        //then
        assertEquals(Operator.DIVIDE, operator);
    }

    @DisplayName("파라미터로 넘긴 문자열이 연산자가 아니라면 예외를 던진다.  ")
    @Test
    void findOperatorThrowException() {
        //given
        String operatorStr = "]";
        //when & then
        assertThrows(IllegalArgumentException.class, () -> Operator.findOperator(operatorStr));

    }

    @DisplayName("파라미터로 넘긴 문자열이 연산자라면 true를 리턴한다. ")
    @Test
    void isOperatorReturnTrue() {
        //given
        String operatorStr = "+";
        //when
        boolean isOperator = Operator.isOperator(operatorStr);
        //then
        assertTrue(isOperator);
    }

    @DisplayName("파라미터로 넘긴 문자열이 연산자가 아니라면 false를 리턴한다. ")
    @Test
    void isOperatorReturnFalse() {
        //given
        String operatorStr = "3";
        //when
        boolean isOperator = Operator.isOperator(operatorStr);
        //then
        assertFalse(isOperator);
    }

    @DisplayName("isHigherPriority() 테스트 - 파라미터로 넘긴 연산자가 *와 / 라면 true를 리턴한다.")
    @Test
    void isHigherPriorityOperatorReturnTrue() {
        //given
        String multiplyOperatorStr = "*";
        String divideOperatorStr = "/";

        //when
        boolean isHigherPriorityFromMultiplyStr = Operator.isHigherPriorityOperator(multiplyOperatorStr);
        boolean isHigherPriorityFromDivideStr = Operator.isHigherPriorityOperator(divideOperatorStr);

        //then
        assertTrue(isHigherPriorityFromMultiplyStr);
        assertTrue(isHigherPriorityFromDivideStr);
    }

    @DisplayName("isHigherPriority() 테스트 -  파라미터로 넘긴 연산자가 + 와 / 라면 false를 리턴한다.")
    @Test
    void isHigherPriorityOperatorReturnFalse() {
        //given
        String addOperatorStr = "+";
        String subtractOperatorStr = "-";

        //when
        boolean isHigherPriorityFromAddStr = Operator.isHigherPriorityOperator(addOperatorStr);
        boolean isHigherPriorityFromSubtractStr = Operator.isHigherPriorityOperator(subtractOperatorStr);

        //then
        assertFalse(isHigherPriorityFromAddStr);
        assertFalse(isHigherPriorityFromSubtractStr);
    }

    @DisplayName("isHigherPriority() 테스트 - 파라미터로 넘긴 문자열이 연산자가 아니라면 false를 리턴한다.")
    @Test
    void isHigherPriorityOperatorWithNotOperatorReturnFalse() {
        //given
        String notOperatorStr = "3";
        //when
        boolean isHigherPriority = Operator.isHigherPriorityOperator(notOperatorStr);

        //then
        assertFalse(isHigherPriority);
    }

    @DisplayName("calculate() 테스트 - 파라미터로 넘긴 연산자가 + 이면 두 입력 파라미터를 더한다. ")
    @Test
    void calculateWithAdd() {
        //given
        String operatorStr = "+";
        double leftValue = 1;
        double rightValue = 2;
        //when
        Double calculateResult = Operator.calculate(operatorStr, leftValue, rightValue);

        //then
        assertEquals(3, calculateResult);
    }

    @DisplayName("calculate() 테스트 - 파라미터로 넘긴 연산자가 - 이면 두 입력 파라미터를 뺀다. ")
    @Test
    void calculateWithSubtract() {
        //given
        String operatorStr = "-";
        double leftValue = 1;
        double rightValue = 2;
        //when
        Double calculateResult = Operator.calculate(operatorStr, leftValue, rightValue);

        //then
        assertEquals(-1, calculateResult);
    }

    @DisplayName("calculate() 테스트 -  파라미터로 넘긴 연산자가 * 이면 두 입력 파라미터를 곱한다. ")
    @Test
    void calculateWithMultiply() {
        //given
        String operatorStr = "*";
        double leftValue = 1;
        double rightValue = 2;
        //when
        Double calculateResult = Operator.calculate(operatorStr, leftValue, rightValue);

        //then
        assertEquals(2, calculateResult);
    }

    @DisplayName("calculate() 테스트 -  파라미터로 넘긴 연산자가 / 이고, 나누는 수가 0이 아니라면 두 입력 파라미터를 나눈다. ")
    @Test
    void calculateWithDivideSuccess() {
        //given
        String operatorStr = "/";
        double leftValue = 1;
        double rightValue = 2;
        //when
        Double calculateResult = Operator.calculate(operatorStr, leftValue, rightValue);

        //then
        assertEquals(0.5, calculateResult);
    }

    @DisplayName("calculate() 테스트 -  파라미터로 넘긴 연산자가 / 이고, 나누는 수가 0이라면 예외를 던진다  ")
    @Test
    void calculateWithDivideFailThrowException() {
        //given
        String operatorStr = "/";
        double leftValue = 1;
        double rightValue = 0;

        //when & then
        assertThrows(ArithmeticException.class, () -> Operator.calculate(operatorStr, leftValue, rightValue));
    }

}