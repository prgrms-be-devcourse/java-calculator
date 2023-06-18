package com.programmers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.programmers.io.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class CalculatorTest {
    private final Calculator calculator = new Calculator(new Console());
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;
    private final InputStream inputStream = System.in;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void after() {
        System.setOut(printStream);
        System.setIn(inputStream);
    }

    @Test
    void 계산한다() {
        //given
        String input = "5 + 2 + 34 * 23 / 2 - 3" + "\n";
        String expected = "395";

        //when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //then
        try {
            calculator.calculate();

            assertThat(outputStream.toString()).contains(expected);
        } catch (NoSuchElementException ignore) {
        }
    }

    @Test
    void 후위표기식을_계산한다() {
        //given
        List<String> postfix = Arrays.asList(
                "5", "2", "+", "34", "23", "*", "2", "/", "+", "3", "-"
        );

        //when
        int result = calculator.calculatePostfix(postfix);

        //then
        assertThat(result).isEqualTo(395);
    }

    @CsvSource(value = {
            "1 : 3 : 3",
            "2,4 : + : 6"
    }, delimiter = ':')
    @ParameterizedTest
    void 숫자면_스택에_삽입하고_숫자가_아니면_연산하고_스택에_삽입한다(String stackElement, String input, int stackTop) {
        //given
        Stack<Integer> stack = new Stack<>();

        Arrays.stream(stackElement.split(","))
                .forEach(x -> stack.push(Integer.valueOf(x)));

        //when
        calculator.handleStack(input, stack);

        //then
        assertThat(stack.peek()).isEqualTo(stackTop);
    }

    @Test
    void 스택의_수들을_꺼내어_계산한다() {
        //given
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);

        String token = "*";

        //when
        int result = calculator.operate(stack, token);

        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    void 계산한_결과를_저장한다() {
        //given
        List<String> input = Arrays.asList(
                "5", "+", "2", "+", "34", "*", "23", "/", "2", "-", "3"
        );
        int inputResult = 395;

        CalculatorRepository calculatorRepository = new CalculatorRepository();

        //when
        calculator.saveExpressionResult(input, inputResult);
        List<String> result = calculatorRepository.findAll();

        //then
        assertThat(result).contains("5 + 2 + 34 * 23 / 2 - 3 = 395");
    }

    @Test
    void 계산식에_공백을_추가하여_재배열한다() {
        //given
        List<String> expression = Arrays.asList("5", "+", "2", "+", "34", "*", "23", "/", "2", "-", "3");
        int expressionResult = 395;

        //when
        String result = calculator.rearrangeExpression(expression, expressionResult);

        //then
        assertThat(result).contains("5 + 2 + 34 * 23 / 2 - 3 = 395");
    }
}