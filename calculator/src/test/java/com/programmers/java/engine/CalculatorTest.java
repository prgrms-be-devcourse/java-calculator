package com.programmers.java.engine;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.model.Expression;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    public void 식_변환_테스트() {
        //given
        String ex1 = "14 + 2.0 * 3.1 - 0.1 / 214";
        String[] op1 = {"+", "*", "-", "/"};
        Double[] num1 = {14.0, 2.0, 3.1, 0.1, 214.0};

        //when
        Optional<Expression> expression = calculator.parseExpression(ex1);

        //then
        System.out.println(expression.get());
        assertArrayEquals(op1, expression.get().getOperators().toArray());
        assertArrayEquals(num1, expression.get().getNumbers().toArray());
    }
}