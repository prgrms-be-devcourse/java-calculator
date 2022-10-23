package com.programmers.java.engine;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.model.Expression;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void init() {
        Console console = new Console();
        Operator operator = new Operator();
        calculator = new Calculator(operator, console);
    }

    @Test
    public void 옵션_변환_테스트() {
        //given
        String option1 = "1";
        String option2 = "5";
        String option3 = "a";

        //when
        Optional<Integer> integer1 = calculator.parseOption(option1);
        Optional<Integer> integer2 = calculator.parseOption(option2);
        Optional<Integer> integer3 = calculator.parseOption(option3);

        //then
        assertEquals(integer1, Optional.of(1));
        assertEquals(integer2, Optional.empty());
        assertEquals(integer3, Optional.empty());
    }

    @Test
    public void 식_토큰화_테스트() {
        //given
        String ex1 = "14 + 2.0 * 3.1 - 0.1 / 214";
        String[] op1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};

        //when
        Optional<Expression> expression = calculator.parseExpression(ex1);

        //then
        System.out.println(expression.get());
        assertArrayEquals(op1, expression.get().getTokens());
    }

    @Test
    public void 후위연산_변환_테스트() {
        //given
        String[] ex1 = {"14", "+", "2.0", "*", "3.1", "-", "0.1", "/", "214"};
        String[] ans1 = {"14", "2.0", "3.1", "*", "+", "0.1", "214", "/", "-"};
        String[] ex2 = {"3", "*", "2", "-", "5"};
        String[] ans2 = {"3", "2", "*", "5", "-"};

        //when
        String[] postfix1 = calculator.makePostfix(ex1);
        String[] postfix2 = calculator.makePostfix(ex2);

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
        Double result1 = calculator.getResult(ex1);
        Double result2 = calculator.getResult(ex2);

        //then
        System.out.println(result1);
        System.out.println(result2);
        assertEquals(ans1, result1);
        assertEquals(ans2, result2);
    }
}