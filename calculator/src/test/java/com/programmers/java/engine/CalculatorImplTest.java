package com.programmers.java.engine;

import com.programmers.java.application.Operator;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.MenuType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorImplTest {

    private static CalculatorImpl calculatorImpl;

    @BeforeAll
    public static void init() {
        Operator operator = new Operator();
        calculatorImpl = new CalculatorImpl(operator);
    }

    @Test
    public void 옵션_변환_테스트() {
        //given
        String option1 = "1";
        String option2 = "5";
        String option3 = "a";

        //when
        Optional<MenuType> integer1 = calculatorImpl.parseOption(option1);
        Optional<MenuType> integer2 = calculatorImpl.parseOption(option2);
        Optional<MenuType> integer3 = calculatorImpl.parseOption(option3);

        //then
        assertEquals(integer1, Optional.of(MenuType.HISTORY));
        assertEquals(integer2, Optional.empty());
        assertEquals(integer3, Optional.empty());
    }

    @Test
    public void 식_토큰화_테스트() {
        //given
        String expression1 = "14 + 2.0 * 3.1 - 0.1 / 214";
        String[] tokenizedExpression1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
        String expression2 = "1 / 0";
        String[] tokenizedExpression2 = {"1", "/", "0"};

        //when
        Optional<Expression> resultExpression1 = calculatorImpl.parseExpression(expression1);
        Optional<Expression> resultExpression2 = calculatorImpl.parseExpression(expression1);

        //then
        System.out.println(resultExpression1.get());
        assertArrayEquals(tokenizedExpression1, resultExpression1.get().getTokens());

        System.out.println(resultExpression1.get());
        assertArrayEquals(tokenizedExpression1, resultExpression1.get().getTokens());
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