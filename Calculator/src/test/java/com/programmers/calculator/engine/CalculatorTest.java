package com.programmers.calculator.engine;

import com.programmers.calculator.engine.io.Console;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.repository.MemoryCalculatorRepository;
import com.programmers.calculator.engine.validation.CalculatorValidator;
import com.programmers.calculator.engine.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private CalculatorRepository repository = new MemoryCalculatorRepository();
    private Validator validator = new CalculatorValidator();
    private Input input = new Console();
    private Output output = new Console();
    private Calculator calculator = new Calculator(input, output, repository, validator);

    @Test
    @DisplayName("들어오는 문자열 파싱 테스트")
    void testParse() {
        String inputString = "3 + 4";
        Queue<String> answer = new LinkedList<>();
        answer.add("3");
        answer.add("4");
        answer.add("+");
        Queue<String> parse = calculator.parse(inputString);

        assertEquals(answer, parse);
    }

    @Test
    @DisplayName("계산기 로직 테스트")
    void testCalculate() {
        String inputString = "3 * 4";
        Queue<String> inputQueue = calculator.parse(inputString);
        int answer = 12;
        Integer result = calculator.calculate(inputQueue);

        assertEquals(answer, result);
    }

    @Test
    @DisplayName("사칙연산에 따른 우선순위 테스트")
    void testPriority() {
        assertEquals(Optional.of(1), calculator.priority("+"));
        assertEquals(Optional.of(2), calculator.priority("/"));
        assertEquals(Optional.empty(), calculator.priority(""));
    }

    @Test
    @DisplayName("문자열이 정수인지 확인하는 메서드")
    void testIsStringInteger() {
        assertTrue(calculator.isStringInteger("13"));
        assertFalse(calculator.isStringInteger("dfdf"));
        assertFalse(calculator.isStringInteger(""));
    }
}
