package com.programmers.calculator.core;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Expression - 연산식 객체 테스트")
class ExpressionTest {


    @DisplayName("생성 성공 테스트 - 정상적인 문자열 식으로 생성된다. ")
    @Test
    void createTestSuccess() {
        //given
        String expressionStr = "1 + 1 + 1";
        //when & then
        Expression expression = assertDoesNotThrow(() -> new Expression(expressionStr));
        assertEquals(expressionStr, expression.getExpressionString());
    }

    @DisplayName("생성 실패 테스트 - 비어있는 문자열 식이 전달되면 예외가 발생한다.")
    @Test
    void createTestFailIfEmptyExpressionStringThrowException() {
        //given
        String emptyExpressionStr = "  ";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Expression(emptyExpressionStr));

    }

    @DisplayName("생성 실패 테스트 - 문자열의 첫번째 인덱스의 값과 마지막 인덱스의 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createTestFailExpressionStringRuleNotNumberThrowException() {
        //given
        String expressionStr = "+ 1 + 1 +";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Expression(expressionStr));
    }

    @DisplayName("생성 실패 테스트 - 문자열 식을 분리한 갯수가 짝수라면 예외가 발생한다. ")
    @Test
    void createTestFailExpressionStringLengthEvenThrowException() {
        //given
        String expressionStr = "1 + 1 +";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Expression(expressionStr));
        assertEquals(0, expressionStr.split(" ").length % 2);
    }

    @DisplayName("생성 실패 테스트 - 문자열 식을 분리한 배열에서 홀수 인덱스가 연산자가 아니라면 예외가 발생한다. ")
    @Test
    void createTestFailExpressionStringArrayOddIndexNotOperatorThrowException() {
        //given
        String expressionStr = "1 + 3 + 3 3 + 3";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Expression(expressionStr));
        assertThrows(NumberFormatException.class, () -> {
            String[] expressionStrSplit = expressionStr.split(" ");
            for (int i = 1; i < expressionStrSplit.length; i+=2) {
                Double.parseDouble(expressionStrSplit[i]);
            }
        });
    }


    @DisplayName("생성 실패 테스트 - 문자열 식을 분리한 배열에서 짝수 인덱스가 숫자가 아니라면 예외가 발생한다. ")
    @Test
    void createTestFailExpressionStringArrayEvenIndexNotNumberThrowException() {
        //given
        String expressionStr = "1 + 3 + + + 7 + 3";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> new Expression(expressionStr));
        assertThrows(NumberFormatException.class, () -> {
            String[] expressionStrSplit = expressionStr.split(" ");
            for (int i = 0; i < expressionStrSplit.length; i+=2) {
                Double.parseDouble(expressionStrSplit[i]);
            }
        });
    }

    @DisplayName("문자열 반환 테스트 - 정상적으로 생성된다면 입력값을 배열로 만든 문자열을 리턴한다.")
    @Test
    void expressionSplitArray() {
        //given
        String expressionStr = "1 + 3 + 5 + 7";
        //when
        Expression expression = new Expression(expressionStr);

        //then
        List<String> expressionSplitArray = expression.expressionSplitList();

        List<String> expressionStrSplit = Arrays.asList(expressionStr.split(" "));

//        assertArrayEquals(expressionStrSplit, expressionSplitArray);

        assertEquals(expressionStrSplit, expressionSplitArray);
    }

    @DisplayName("문자열 반환 테스트 - 정상적으로 생성된다면 입력값 문자열을 리턴한다.")
    @Test
    void getExpressionString() {
        //given
        String expressionStr = "1 + 3 + 5 + 7";

        //when
        Expression expression = new Expression(expressionStr);

        //then
        assertEquals(expressionStr, expression.getExpressionString());
    }

}