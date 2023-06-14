package com.wonu606.calculator.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import com.wonu606.calculator.calculator.PostfixCalculator;
import com.wonu606.calculator.converter.InfixToPostfixConverter;
import com.wonu606.calculator.storage.ResultStore;
import com.wonu606.calculator.util.CalculatorMessage;
import com.wonu606.calculator.validator.InfixValidator;
import com.wonu606.io.ConsoleInput;
import com.wonu606.io.ConsolePrinter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationStrategyTest {

    @Test
    @DisplayName("정상 입력")
    void testNormalInput() {
        // given
        CalculatorStrategy calculator = new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator());

        String expression = "2 + 3";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        calculator.execute(new ConsoleInput(), new ConsolePrinter(), new ResultStore());

        // then
        String expectedResult = 5 + "\n";
        assertThat(expectedResult).isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("Double 오버 플로우 발생")
    void testDoubleOverflowOccurs() {
        // given
        CalculatorStrategy calculator = new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator());

        String expression = Double.MAX_VALUE + " + 1";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        calculator.execute(new ConsoleInput(), new ConsolePrinter(), new ResultStore());

        // then
        String expectedResult = CalculatorMessage.OVERFLOW_OCCURS.message + "\n";
        assertThat(expectedResult).isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("Integer 오버 플로우 발생")
    void testIntegerOverflowOccurs() {
        // given
        CalculatorStrategy calculator = new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator());

        String expression = Integer.MAX_VALUE + " + 1";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        calculator.execute(new ConsoleInput(), new ConsolePrinter(), new ResultStore());

        // then
        String expectedResult = CalculatorMessage.OVERFLOW_OCCURS.message + "\n";
        assertThat(expectedResult).isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("0으로 나눌 경우 오류 발생")
    void testDividedByZero() {
        // given
        CalculatorStrategy calculator = new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator());

        String expression = "10 / 0";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        calculator.execute(new ConsoleInput(), new ConsolePrinter(), new ResultStore());

        // then
        String expectedResult = CalculatorMessage.NOT_DIVISIBLE_BY_ZERO.message + "\n";
        assertThat(expectedResult).isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("중위 연산식이 아닌 경우")
    void testIsNotInfixExpression() {
        // given
        CalculatorStrategy calculator = new CalculationStrategy(
                new InfixValidator(), new InfixToPostfixConverter(), new PostfixCalculator());

        String expression = "3 5 +";
        InputStream in = new ByteArrayInputStream(expression.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(outContent));

        // when
        calculator.execute(new ConsoleInput(), new ConsolePrinter(), new ResultStore());

        // then
        String expectedResult = CalculatorMessage.INVALID_INPUT.message + "\n";
        assertThat(expectedResult).isEqualTo(outContent.toString());
    }
}
