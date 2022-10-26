package com.programmers.java.engine;

import com.programmers.java.engine.calculator.CalculatorImpl;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorImplTest {

    private static CalculatorImpl calculatorImpl;

    @BeforeAll
    public static void init() {
        calculatorImpl = new CalculatorImpl();
    }

    @Test
    public void 식_토큰화_테스트() {
        //given
        String expression1 = "14 + 2.0 * 3.1 - 0.1 / 214";
        String[] tokenizedExpression1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
        String expression2 = "1 / 0";
        String[] tokenizedExpression2 = {"1", "/", "0"};

        //when
        Expression resultExpression1 = calculatorImpl.parseExpression(expression1);
        Expression resultExpression2 = calculatorImpl.parseExpression(expression1);

        //then
        System.out.println(resultExpression1);
        assertArrayEquals(tokenizedExpression1, resultExpression1.getTokens());

        System.out.println(resultExpression1);
        assertArrayEquals(tokenizedExpression1, resultExpression1.getTokens());
    }

    @Test
    public void 후위연산_변환_테스트() {
        //given
        String[] ex1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
        String[] ans1 = {"14", "2.0", "3.1", "*", "+", "0.1", "214", "/", "-"};
        String[] ex2 = {"3", "*", "2", "-", "5"};
        String[] ans2 = {"3", "2", "*", "5", "-"};

        //when
        String[] postfix1 = calculatorImpl.makePostfix(ex1);
        String[] postfix2 = calculatorImpl.makePostfix(ex2);

        //then
        System.out.println(Arrays.toString(postfix1));
        System.out.println(Arrays.toString(postfix2));
        assertArrayEquals(ans1, postfix1);
        assertArrayEquals(ans2, postfix2);
    }

    @Test
    public void 연산_테스트() {
        //given
        String[] ex1 = {"14", "2.0", "3.1", "*", "+", "10", "2", "/", "-"};
        String[] ex2 = {"3", "2", "*", "5", "-"};
        Double ans1 = 15.2;
        Double ans2 = 1.0;

        //when
        Answer result1 = calculatorImpl.getResult(ex1);
        Answer result2 = calculatorImpl.getResult(ex2);

        //then
        System.out.println(result1.getValue());
        System.out.println(result2.getValue());
        assertEquals(ans1, result1.getValue());
        assertEquals(ans2, result2.getValue());
    }
}